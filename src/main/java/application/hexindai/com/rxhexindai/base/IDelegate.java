package application.hexindai.com.rxhexindai.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by zhangruiyu on 16/5/18.
 */
public interface  IDelegate {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    int getOptionsMenuId();

    Toolbar getToolbar();

    int getRootViewID();

    void initWidget();
}
