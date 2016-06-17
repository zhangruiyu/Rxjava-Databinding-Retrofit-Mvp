package application.hexindai.com.rxhexindai.modular.homepage;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import application.hexindai.com.rxhexindai.network.Network;
import application.hexindai.com.rxhexindai.network.ProgressSubscriber;

/**
 * Created by zhangruiyu on 16/5/19.
 * 从UI界面监听动作,  检查数据并回调更新界面
 */
public class HomepagePersenter implements HomepageContract.Presenter

{
    private HomepageContract.View mHomepageView;

    public HomepagePersenter(HomepageContract.View mHomepageView) {
        this.mHomepageView = mHomepageView;
        mHomepageView.setPresenter(this);
    }

    @Override
    public void start() {
        //获取数据
        loadAllBid();
    }


    @Override
    public void loadAllBid() {
        Network.getInstance().getAllBidList().doOnSubscribe(() -> mHomepageView.setLoadingIndicator(true)).doAfterTerminate(() ->
                mHomepageView.setLoadingIndicator(false)
        ).doOnError(throwable ->
                mHomepageView.showAllBid(new ArrayList<>(0))
        ).subscribe(new ProgressSubscriber<SumNotFillInfo.DataBean>() {
            @Override
            public void onNext(SumNotFillInfo.DataBean dataBean) {
                mHomepageView.showAllBid(dataBean.list);
            }
        });
    }

    @Override
    public void openJoinLend(@NonNull SumNotFillInfo.DataBean.ListBean listBean) {
        mHomepageView.openJoinLendUi(listBean);
    }


}
