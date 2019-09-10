package com.anonyper.logincomponent;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anonyper.basecomponent.UserManager;
import com.anonyper.utillibrary.Loger;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/27.
 */
@Interceptor(priority = 1, name = "登陆拦截")
public
class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Loger.d("处理拦截任务：" + postcard.getPath());
        if (postcard.getPath().equals("/3333/mine")) {
            if (!UserManager.getInstance().isLogin()) {
                LoginJumpeManager.getInstance().setPostcard(postcard);
                ARouter.getInstance().build("/2222/login").navigation();
                return;
            }
        }
        Loger.d("处理拦截任务后：" + postcard.getPath());
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Loger.d("登陆拦截起初始化");
    }

    public boolean loginInit(Postcard postcard) {
        try {
            LogisticsCenter.completion(postcard);
            return true;
        } catch (NoRouteFoundException ex) {
            Loger.w(ex.getMessage());
            return false;
        }
    }
}
