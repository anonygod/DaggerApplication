package com.anonyper.minecomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/3333/mine")
public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        this.findViewById(R.id.mine_text).setOnClickListener(view ->
                ARouter.getInstance().build("/2222/login").navigation()
        );
        new Thread(() -> {

        }) {
        }.start();
        //上报加载时间
        reportFullyDrawn();
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
