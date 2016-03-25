package cc.dayku.androidanimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
    }

    public void alphaClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        iv_icon.startAnimation(animation);
    }

    public void retateLeftClick(View v) {
    }

    public void retateRightClick(View v) {
    }

    public void scaleBigClick(View v) {
    }

    public void scaleLitteClick(View v) {
    }

    public void translateClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        iv_icon.startAnimation(animation);
    }

    public void nineOldClick(View v) {
        startActivity(new Intent(this, NineOldActivity.class));
    }
    public void iconClick(View v){
        Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
    }
}
