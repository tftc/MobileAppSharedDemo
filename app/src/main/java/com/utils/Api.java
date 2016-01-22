package com.utils;

import com.mvc.model.User;

/**
 * Created by dayku on 16/1/21.
 */
public class Api {
    public User getUser(){
        return new User("http://img4.imgtn.bdimg.com/it/u=3320670811,1178842717&fm=21&gp=0.jpg","李","三","男",18);
    }
}
