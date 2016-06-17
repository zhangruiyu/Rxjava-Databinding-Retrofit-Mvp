package application.hexindai.com.rxhexindai.modular.homepage;

/**
 * Created by zhangruiyu on 16/5/20.
 */
public class HomePageActionHander {
    private HomepageContract.Presenter mPresenter;

    public HomePageActionHander(HomepageContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void joinLendClick(SumNotFillInfo.DataBean.ListBean listBean) {
        mPresenter.openJoinLend(listBean);
    }
}
