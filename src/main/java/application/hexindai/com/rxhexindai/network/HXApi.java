package application.hexindai.com.rxhexindai.network;

import application.hexindai.com.rxhexindai.base.HttpResult;
import application.hexindai.com.rxhexindai.modular.homepage.SumNotFillInfo;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by zhangruiyu on 16/5/19.
 */
public interface HXApi {
    @POST(Api.ALLBID_LIST)
    Observable<HttpResult<SumNotFillInfo.DataBean>> getBidList();
}
