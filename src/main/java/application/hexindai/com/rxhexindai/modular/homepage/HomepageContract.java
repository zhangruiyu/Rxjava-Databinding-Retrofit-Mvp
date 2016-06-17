package application.hexindai.com.rxhexindai.modular.homepage;

import android.support.annotation.NonNull;

import java.util.List;

import application.hexindai.com.rxhexindai.base.BasePresenter;
import application.hexindai.com.rxhexindai.base.BaseView;

/**
 * Created by zhangruiyu on 16/5/19.
 */
public interface HomepageContract {
    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showAllBid(List<SumNotFillInfo.DataBean.ListBean> listBeen);

        void openJoinLendUi(@NonNull SumNotFillInfo.DataBean.ListBean listBean);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void loadAllBid();


        void openJoinLend(@NonNull SumNotFillInfo.DataBean.ListBean listBean);

        /*default int getI() {
            return 1;
        }*/
    }
}
