package com.bawei.zhujinru20191230;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.zhujinru20191230.base.BaseActivity;
import com.bawei.zhujinru20191230.contract.HomeContract;
import com.bawei.zhujinru20191230.model.bean.GsobBean;
import com.bawei.zhujinru20191230.presenter.HomePresenter;
import com.bawei.zhujinru20191230.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.IView {


    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected HomePresenter providerPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getHomeData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(GsobBean gsobBean) {


        NetUtil.getInstance().getJsonGet("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                tvContent.setText(json);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
