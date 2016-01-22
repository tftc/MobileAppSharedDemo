package com.utils.bind;

import android.widget.ImageView;

import org.robobinding.viewbinding.BindingAttributeMappings;
import org.robobinding.viewbinding.ViewBinding;

/**
 * Created by dayku on 15/11/30.
 * 自定义ImageView属性
 */
public class ImageViewBinding implements ViewBinding<ImageView> {
    @Override
    public void mapBindingAttributes(BindingAttributeMappings<ImageView> mappings) {
        mappings.mapOneWayProperty(UrlAttbute.class, "url");
    }
}
