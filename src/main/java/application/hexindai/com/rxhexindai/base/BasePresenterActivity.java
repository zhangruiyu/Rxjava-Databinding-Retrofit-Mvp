package application.hexindai.com.rxhexindai.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import application.hexindai.com.rxhexindai.R;

/**
 * Created by zhangruiyu on 16/5/18.
 */
public abstract class BasePresenterActivity<V extends ViewDataBinding> extends BaseActivity {

    protected V viewDataBinding;
    protected Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  viewDataBinding = DataBindingUtil.setContentView(this, viewDelegate.getRootViewID());
        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        initToolbar();
    }

    protected void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewDelegate = null;
    }

}
