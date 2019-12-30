package com.bawei.zhujinru20191230.presenter;

import com.bawei.zhujinru20191230.base.BasePresenter;
import com.bawei.zhujinru20191230.contract.HomeContract;
import com.bawei.zhujinru20191230.model.HomeModel;
import com.bawei.zhujinru20191230.model.bean.GsobBean;

public class HomePresenter extends BasePresenter<HomeContract.IView> implements HomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new HomeContract.IModel.IModelCallBack() {
            @Override
            public void onSuccess(GsobBean gsobBean) {
                view.onSuccess(gsobBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
