package application.hexindai.com.rxhexindai.modular.homepage;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.view.View;

/**
 * Created by zhangruiyu on 16/5/19.
 * 暴漏Controntract.view使用的数据
 */
public class HomepageViewModel extends BaseObservable {
    public ObservableInt mHaveData = new ObservableInt(View.GONE);
    public ObservableInt mNoData = new ObservableInt(View.GONE);
    public ObservableBoolean isfresh = new ObservableBoolean();
    private Context mContext;
    private final HomepagePersenter mHomepagePersenter;

    public HomepageViewModel(Context mContext, HomepagePersenter mHomepagePersenter) {
        this.mHomepagePersenter = mHomepagePersenter;
        this.mContext = mContext;
    }

    public void setSize(int size) {
        mHaveData.set(size > 0 ? View.VISIBLE : View.GONE);
        mNoData.set(size <= 0 ? View.VISIBLE : View.GONE);
    }
}
