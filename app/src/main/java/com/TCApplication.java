package com;

import android.app.Application;
import android.view.View;
import android.widget.ImageView;

import com.utils.bind.AnimAttribute;
import com.utils.bind.ImageViewBinding;

import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;
import org.robobinding.customviewbinding.CustomViewBinding;

/**
 * Created by dayku on 15/11/5.
 */
public class TCApplication extends Application {
    private BinderFactory reusableBinderFactory;
    public static TCApplication globalContext;
    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;
        reusableBinderFactory = new BinderFactoryBuilder()
                .add(new AnimAttribute().extend(View.class))
                .add(CustomViewBinding.forView(ImageView.class, new ImageViewBinding()))
                .build();
    }

    public BinderFactory getReusableBinderFactory() {
        return reusableBinderFactory;
    }

    public static TCApplication getGlobalContext() {
        return globalContext;
    }

    public static void setGlobalContext(TCApplication globalContext) {
        TCApplication.globalContext = globalContext;
    }

}
