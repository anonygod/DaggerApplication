package com.anonyper.logincomponent;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/28.
 */
public class LoginJumpeManager {
    private static LoginJumpeManager loginJumpeManager;

    private LoginJumpeManager() {

    }

    public static LoginJumpeManager getInstance() {
        synchronized (LoginJumpeManager.class) {
            if (loginJumpeManager == null) {
                loginJumpeManager = new LoginJumpeManager();
            }
        }
        return loginJumpeManager;
    }

    /**
     * 需要登陆之后跳转的界面
     */
    private Postcard postcard;

    /**
     * 设置要跳转的postCard
     *
     * @param postcard
     */
    public void setPostcard(Postcard postcard) {
        this.postcard = postcard;
    }

    /**
     * 登陆之后跳转
     */
    public void jumpto() {
        if (postcard != null) {
            postcard.navigation();
            postcard = null;
        }

    }
}
