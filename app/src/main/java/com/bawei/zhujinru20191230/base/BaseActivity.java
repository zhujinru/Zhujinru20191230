package com.bawei.zhujinru20191230.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=providerPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract P providerPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
