package com.utils.bind;

import android.view.View;

import org.robobinding.annotation.ViewBinding;
import org.robobinding.customviewbinding.CustomViewBinding;

/**
 * Created by dayku on 15/11/30.
 * ImageView anim
 * 适用这种方法的前提下，该View必需自带该属性的set方法
 * 例如： animation 有 view.setAnimation()方法
 * 此类需要在application里面注册
 */
@ViewBinding(simpleOneWayProperties = {"animation"})
public class AnimAttribute extends CustomViewBinding<View> {

}