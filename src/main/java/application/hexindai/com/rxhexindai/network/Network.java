package application.hexindai.com.rxhexindai.network;

import android.text.TextUtils;

import application.hexindai.com.rxhexindai.base.HttpResult;
import application.hexindai.com.rxhexindai.modular.homepage.SumNotFillInfo;
import application.hexindai.com.rxhexindai.util.HXLog;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangruiyu on 16/5/19.
 */
public class Network {
    private final Retrofit build;
    private HXApi hxApi;

    private Network() {
        //打印请求log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message ->
                HXLog.d(message)
        ).setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor interceptor = chain -> {
            Request original = chain.request();

            RequestBody formBody = (RequestBody) original.body();
            FormBody formBody2 = new FormBody.Builder().add("type", "6").build();

            //请求定制：添加请求头
            Request.Builder requestBuilder = original.newBuilder()
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        };
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(httpLoggingInterceptor).build();
        this.build = new Retrofit.Builder()
                .client(build)
                .baseUrl(Api.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        hxApi = this.build.create(HXApi.class);
    }

    private static class SingletonHolder {
        private static final Network INSTANCE = new Network();
    }

    public static Network getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final class HttpResultFuncC<T> implements Observable.Transformer<HttpResult<T>, T> {
        @Override
        public Observable<T> call(Observable<HttpResult<T>> httpResultObservable) {
            return httpResultObservable.map(tHttpResult -> {
                if (tHttpResult.ret_code > 1000 || !TextUtils.isEmpty(tHttpResult.ret_msg)) {//code大于1000或者msg不为空
                    HXLog.d(tHttpResult.ret_msg);
                    throw new ApiException(tHttpResult.ret_msg);
                }
                return tHttpResult.data;
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    private final HttpResultFuncC httpResultFuncC = new HttpResultFuncC();


    /**
     * 获取出借页面标列表信息
     *
     * @return
     */
    public Observable<SumNotFillInfo.DataBean> getAllBidList() {
        Observable<HttpResult<SumNotFillInfo.DataBean>> bidList = hxApi.getBidList();
        return bidList.compose(httpResultFuncC);
    }

}
