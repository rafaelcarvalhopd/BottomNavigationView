package com.rca.bottomnavigationview.view.fragment;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by home on 03/02/17.
 */
public class FadePageTransformer implements ViewPager.PageTransformer {

    public FadePageTransformer(ViewPager viewPager) {

        viewPager.setOnTouchListener(onTouchListener);
    }

    public void transformPage(View view, float position) {

        view.setTranslationX(view.getWidth() * -position);

        if(position <= -1.0F || position >= 1.0F) {

            view.setAlpha(0.0F);

        } else if( position == 0.0F ) {

            view.setAlpha(1.0F);

        } else {

            view.setAlpha(1.0F - Math.abs(position));
        }
    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    };
}