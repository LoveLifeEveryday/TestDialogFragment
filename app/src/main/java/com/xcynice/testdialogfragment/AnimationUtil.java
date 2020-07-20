package com.xcynice.testdialogfragment;


import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * @Author 许朋友爱玩
 * @Date 2020/7/20 00:31
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description AnimationUtil
 */

public class AnimationUtil {

    public static void slideToDown(View view, final AnimationEndListener listener) {
        Animation slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);

        slide.setDuration(400);
        slide.setFillEnabled(true);
        slide.setFillAfter(true);
        view.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (listener != null) {
                    listener.onFinish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    public static void slideToUp(View view) {
        Animation slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        slide.setDuration(400);
        slide.setFillEnabled(true);
        slide.setFillAfter(true);
        view.startAnimation(slide);

    }


    public interface AnimationEndListener {
        void onFinish();
    }
}
