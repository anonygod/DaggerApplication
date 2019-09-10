package com.anonyper.logincomponent;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.anonyper.basecomponent.BaseActivity;
import com.anonyper.basecomponent.UserManager;
import com.anonyper.utillibrary.Loger;

@Route(path = "/2222/login")
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();
        long user_id = bundle.getLong("user_id");
        Loger.i("user_id = " + user_id);
        this.findViewById(R.id.login_text).setOnClickListener(view -> {
//            ARouter.getInstance().build("arouter://m.aliyun.com/test/login").navigation();
        });
        UserManager.getInstance().initUser();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoginJumpeManager.getInstance().jumpto();
    }
}
