package com.anonyper.daggerapplication.bean;

import javax.inject.Inject;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/19.
 */
public class Student {
    @Inject
    public String name;

    //    @Inject
    public Student(String name) {
        this.name = name;
    }
}
