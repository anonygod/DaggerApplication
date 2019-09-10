package com.anonyper.daggerapplication;

import android.annotation.TargetApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anonyper.daggerapplication.bean.Student;
import com.anonyper.daggerapplication.interfaces.DaggerIMainComponent;
import com.anonyper.daggerapplication.module.MainModule;
import com.anonyper.daggerapplication.prensent.MainActivityPrensent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Route(path = "/1111/main")
public class MainActivity extends AppCompatActivity {


    /**
     * Inject 会自动根据provider来赋值
     */
    @Inject
    MainActivityPrensent prensent;
    @Inject
    Student student;

    @Autowired
    int age = 0;

    /**
     * arouter重的注解 会自动填充赋值，和butterknife类似
     */
    @Autowired(name = "123")
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = this.findViewById(R.id.text_view);
        DaggerIMainComponent.builder().mainModule(new MainModule()).build().register(this);

        textView.setText(student.name);
        textView.setOnClickListener(view -> {

            ActivityOptionsCompat compat = ActivityOptionsCompat.
                    makeScaleUpAnimation(textView.getRootView(), textView.getRootView().getWidth() / 2, textView.getRootView().getHeight() / 2, 0, 0);
            ARouter.getInstance().build("/3333/mine").withOptionsCompat(compat).navigation(this, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {

                }
            });

        });

    }

    @Singleton
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
