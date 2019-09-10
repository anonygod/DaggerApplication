package com.anonyper.daggerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 中间跳转的界面
 */
public class WebJumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_jump);
        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        String scheme_callback = this.getIntent().getDataString();
        if (TextUtils.isEmpty(scheme_callback)) {
            return;
        }
        ARouter.getInstance().build("/2222/login").with(bundle).navigation(this, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                finish();
            }
        });
    }
}
