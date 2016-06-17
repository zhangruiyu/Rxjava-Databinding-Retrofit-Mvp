package application.hexindai.com.rxhexindai.modular.homepage;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import application.hexindai.com.rxhexindai.util.UIUtils;


/**
 * Created by zhangruiyu on 16/3/30.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;
    RecyclerView.Adapter adapter;

    /**
     * @param space 传入的值，其单位视为dp
     */
    public SpaceItemDecoration(int space, RecyclerView.Adapter adapter) {
        this.mSpace = UIUtils.dip2px(space);
        this.adapter = adapter;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int itemCount = adapter.getItemCount();
        int pos = parent.getChildAdapterPosition(view);

        outRect.left = 0;
        outRect.bottom = 0;
        outRect.right = 0;

        outRect.top = mSpace;
        if (pos == (itemCount - 1)) {
            outRect.bottom = mSpace * 2;
        }
    }
}
