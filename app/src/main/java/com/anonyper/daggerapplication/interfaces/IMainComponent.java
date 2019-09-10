package com.anonyper.daggerapplication.interfaces;

import com.anonyper.daggerapplication.MainActivity;
import com.anonyper.daggerapplication.module.MainModule;

import dagger.Component;

/**
 * DaggerApplication
 * Created by anonyper on 2019/6/19.
 */
@Component(modules = MainModule.class)
public interface IMainComponent {
    void register(MainActivity mainActivity);
}
