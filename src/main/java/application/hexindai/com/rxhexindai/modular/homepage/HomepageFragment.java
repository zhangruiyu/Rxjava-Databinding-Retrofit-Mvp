package application.hexindai.com.rxhexindai.modular.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import application.hexindai.com.rxhexindai.R;
import application.hexindai.com.rxhexindai.databinding.FragmentMainBinding;

/**
 * Created by zhangruiyu on 16/5/19.
 */
public class HomepageFragment extends RxFragment implements HomepageContract.View {

    private FragmentMainBinding fragmentMainBinding;
    private HomepageAllbidAdapter homepageAllbidAdapter;
    private HomepageViewModel homepageViewModel;

    public static HomepageFragment newInstance() {
        return new HomepageFragment();
    }

    private HomepageContract.Presenter mPresenter;

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull HomepageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        fragmentMainBinding.setHomepagemodel(homepageViewModel);
        fragmentMainBinding.setPresenter(mPresenter);

        //   homepageViewModel.setSize(0);
        RecyclerView recycleShowbid = fragmentMainBinding.recycleShowbid;
        recycleShowbid.setLayoutManager(new LinearLayoutManager(getContext()));
        homepageAllbidAdapter = new HomepageAllbidAdapter(new ArrayList<>(0), mPresenter);
        recycleShowbid.addItemDecoration(new SpaceItemDecoration(10, homepageAllbidAdapter));
        recycleShowbid.setAdapter(homepageAllbidAdapter);
        fragmentMainBinding.swlRefresh.setScrollUpChild(fragmentMainBinding.recycleShowbid);
        //当轮播图完全展示后才可以下拉刷新
        ((AppBarLayout) getActivity().findViewById(R.id.app_bar)).addOnOffsetChangedListener(
                (appBarLayout, verticalOffset) ->
                        fragmentMainBinding.swlRefresh.setEnabled(isActive() && verticalOffset == 0)
        );
        return fragmentMainBinding.getRoot();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swl_refresh);
        swipeRefreshLayout.post(() ->
                homepageViewModel.isfresh.set(active)
        );
    }

    @Override
    public void showAllBid(List<SumNotFillInfo.DataBean.ListBean> listBeen) {
        homepageViewModel.setSize(listBeen.size());
        homepageAllbidAdapter.replaceData(listBeen);
    }

    @Override
    public void openJoinLendUi(@NonNull SumNotFillInfo.DataBean.ListBean requestedTask) {
        Toast.makeText(getActivity(), requestedTask.bid_name, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean isActive() {
        return isAdded();
    }

    public void setHomepageViewModel(HomepageViewModel homepageViewModel) {
        this.homepageViewModel = homepageViewModel;
    }
}
