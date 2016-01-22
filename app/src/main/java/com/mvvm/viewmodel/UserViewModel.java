package com.mvvm.viewmodel;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mvc.model.User;
import com.mvvm.R;

import org.robobinding.annotation.PresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;

/**
 * Created by dayku on 16/1/21.
 */
@PresentationModel
public class UserViewModel implements HasPresentationModelChangeSupport {
    private User user=new User();

    public void setUser(User user){
        this.user=user;
        changeSupport.firePropertyChange("lastName");
        changeSupport.firePropertyChange("firstName");
        changeSupport.firePropertyChange("sex");
        changeSupport.firePropertyChange("age");
        changeSupport.firePropertyChange("title");
    }
    public Animation getRotation(){
       return AnimationUtils.loadAnimation(mContext,R.anim.rotation_view);
    }
    public String getUrl(){
        return  "http://img4.imgtn.bdimg.com/it/u=3320670811,1178842717&fm=21&gp=0.jpg";
    }

    public String getTitle(){
        return user.getLastname()+user.getFirstname();
    }
    public String getLastName(){
        return user.getLastname();
    }
    public String getFirstName(){
        return user.getFirstname();
    }
    public String getSex(){
        return  user.getSex();
    }
    public String getAge(){
        return user.getAge()+"";
    }


    private PresentationModelChangeSupport changeSupport;
    private Context mContext;

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        return changeSupport;
    }

    public UserViewModel(Context context) {
        this.mContext = context;
        changeSupport = new PresentationModelChangeSupport(this);
    }
}
