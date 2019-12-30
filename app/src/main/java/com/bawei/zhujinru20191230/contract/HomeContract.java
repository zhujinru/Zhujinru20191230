package com.bawei.zhujinru20191230.contract;

import com.bawei.zhujinru20191230.model.bean.GsobBean;

public interface HomeContract {
    interface IView{
        void onSuccess(GsobBean gsobBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getHomeData();
    }
    interface IModel{
        void getHomeData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onSuccess(GsobBean gsobBean);
            void onFailure(Throwable throwable);
        }
    }
}
