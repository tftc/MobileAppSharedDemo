package com.utils.bind;

import android.widget.ImageView;


import com.utils.glide.GlideUtils;

import org.robobinding.viewattribute.property.OneWayPropertyViewAttribute;

/**
 * Created by dayku on 15/12/24.
 * 另一种写法：
 * 这种写法应用于该view没有set方法
 * 例如：view.addView(v) 将view添加一个子view 没有类似setAnimation这样的方法，robobinding无法识别出你这是什么属性
 */
public class UrlAttbute implements OneWayPropertyViewAttribute<ImageView,String> {
    @Override
    public void updateView(ImageView view, String url) {
        GlideUtils.getInstance().loadImage(view.getContext(),view,url);
    }
}