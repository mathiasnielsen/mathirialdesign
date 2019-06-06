package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public class CustomTransReenter extends Visibility {
    public CustomTransReenter() {
        super();
    }

    @Override
    public Animator onAppear(ViewGroup sceneRoot, final View view, TransitionValues startValues, TransitionValues endValues) {

        //view.setTranslationX(view.getMeasuredWidth());

        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float)animation.getAnimatedValue();

                // ALPHA
                view.setAlpha(animatedValue);

                // TRANSLATION
                float y = (1.0f - animatedValue) * -view.getMeasuredHeight();
                view.setTranslationY(y);
            }
        });

        return animator;
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        View view = endValues.view;

        // ALPHA
        view.setAlpha(0.0f);

        // TRANSLATE
        view.setTranslationY(-view.getMeasuredHeight());

        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
