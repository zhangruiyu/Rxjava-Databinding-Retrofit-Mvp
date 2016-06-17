package application.hexindai.com.rxhexindai.modular.homepage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import application.hexindai.com.rxhexindai.databinding.ItemLendfgRecycleBinding;

/**
 * Created by zhangruiyu on 16/5/20.
 */
public class HomepageAllbidAdapter extends RecyclerView.Adapter<HomepageFragmentAdapterHolder> {

    private List<SumNotFillInfo.DataBean.ListBean> notFillInfos;
    protected HomepageContract.Presenter mPresenter;

    public List<SumNotFillInfo.DataBean.ListBean> getNotFillInfos() {
        return notFillInfos;
    }


    public HomepageAllbidAdapter(List<SumNotFillInfo.DataBean.ListBean> notFillInfos, HomepageContract.Presenter presenter) {
        this.notFillInfos = notFillInfos;
        this.mPresenter = presenter;
    }

    @Override
    public HomepageFragmentAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        ItemLendfgRecycleBinding itemLendfgRecycleBinding = ItemLendfgRecycleBinding.inflate(from, parent, false);
        itemLendfgRecycleBinding.setHomepageaction(new HomePageActionHander(mPresenter));
        HomepageFragmentAdapterHolder homepageFragmentAdapterHolder = new HomepageFragmentAdapterHolder(itemLendfgRecycleBinding);
        return homepageFragmentAdapterHolder;
    }

    @Override
    public void onBindViewHolder(HomepageFragmentAdapterHolder holder, int position) {
        SumNotFillInfo.DataBean.ListBean listBean = notFillInfos.get(position);
        //   listBean.setState(BidManage.Peheat);
        //     listBean.bid_effect_real_ts = "2016-05-16 17:57:00";
        holder.refreshData(notFillInfos.get(position));
    }


    @Override
    public int getItemCount() {
        return notFillInfos.size();
    }

    public void replaceData(List<SumNotFillInfo.DataBean.ListBean> listBeanList) {
        notFillInfos.clear();
        notFillInfos.addAll(listBeanList);
        notifyDataSetChanged();
    }
}

class HomepageFragmentAdapterHolder extends RecyclerView.ViewHolder {
    private ItemLendfgRecycleBinding itemLendfgRecycleBinding;

    public HomepageFragmentAdapterHolder(ItemLendfgRecycleBinding itemLendfgRecycleBinding) {
        super(itemLendfgRecycleBinding.getRoot());
        this.itemLendfgRecycleBinding = itemLendfgRecycleBinding;
    }

    public void refreshData(SumNotFillInfo.DataBean.ListBean listBean) {

        itemLendfgRecycleBinding.setOnebidinfo(listBean);
    }
}
