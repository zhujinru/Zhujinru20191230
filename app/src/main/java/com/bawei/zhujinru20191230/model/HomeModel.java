package com.bawei.zhujinru20191230.model;

import com.bawei.zhujinru20191230.contract.HomeContract;
import com.bawei.zhujinru20191230.model.bean.GsobBean;
import com.bawei.zhujinru20191230.util.NetUtil;
import com.google.gson.Gson;

public class HomeModel implements HomeContract.IModel {

    @Override
    public void getHomeData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getJsonGet("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                GsobBean gsobBean = new Gson().fromJson(json, GsobBean.class);
                iModelCallBack.onSuccess(gsobBean);
            }

            @Override
            public void onError(Throwable throwable) {
               iModelCallBack.onFailure(throwable);
            }
        });
    }
}
