package com.anonyper.daggerapplication.module;

import com.anonyper.daggerapplication.bean.Student;
import com.anonyper.daggerapplication.prensent.MainActivityPrensent;

import dagger.Provides;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/19.
 */
@dagger.Module
public class MainModule {


    @Provides
    Student provideStudent() {
        return new Student(mainActivityPrensent().name);
    }

    @Provides
    String name(){
        return "zhangsan";
    }

    @Provides
    MainActivityPrensent mainActivityPrensent() {
        return new MainActivityPrensent();
    }
}
