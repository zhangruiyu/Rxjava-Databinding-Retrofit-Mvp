package application.hexindai.com.rxhexindai.delegate;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import application.hexindai.com.rxhexindai.R;
import application.hexindai.com.rxhexindai.base.IDelegate;

/**
 * Created by zhangruiyu on 16/5/18.
 */
public class MainActivityDelegate implements IDelegate {
    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @Override
    public int getRootViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {

    }
}
