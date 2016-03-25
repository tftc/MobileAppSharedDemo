package cc.dayku.androidanimation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewPropertyAnimator;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;


/**
 * Created by dayku on 16/3/25.
 */
public class NineOldActivity extends AppCompatActivity {
    private ImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nineold);
        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        animate(iv_icon).scaleX(2).scaleY(2).setDuration(1000).setListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(com.nineoldandroids.animation.Animator animator) {

            }

            @Override
            public void onAnimationEnd(com.nineoldandroids.animation.Animator animator) {
                animate(iv_icon).scaleX(1).scaleY(1).setDuration(1000).start();
            }

            @Override
            public void onAnimationCancel(com.nineoldandroids.animation.Animator animator) {

            }

            @Override
            public void onAnimationRepeat(com.nineoldandroids.animation.Animator animator) {

            }
        }).start();
    }

    public void alphaClick(View v) {

    }

    public void iconClick(View v) {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }
}
