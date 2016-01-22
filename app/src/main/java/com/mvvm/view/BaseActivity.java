package com.mvvm.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.TCApplication;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;

/**
 * Created by dayku on 15/11/5.
 * 所有activity继承此类
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public void initializeContentView(int layoutId, Object presentationModel) {
        ViewBinder viewBinder = createViewBinder();
        View rootView = viewBinder.inflateAndBind(layoutId, presentationModel);
        setContentView(rootView);
    }

    public ViewBinder createViewBinder() {
        BinderFactory binderFactory = getReusableBinderFactory();
        return binderFactory.createViewBinder(this);
    }

    private BinderFactory getReusableBinderFactory() {
        BinderFactory binderFactory = getTCApplication().getReusableBinderFactory();
        return binderFactory;
    }

    private TCApplication getTCApplication() {
        return (TCApplication)getApplicationContext();
    }

}
