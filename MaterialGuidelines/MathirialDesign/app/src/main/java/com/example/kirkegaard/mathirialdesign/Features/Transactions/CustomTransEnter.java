package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public class CustomTransEnter extends Visibility {

    public CustomTransEnter() {
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

                // TRANSLATE
                float x = (1.0f - animatedValue) * view.getMeasuredWidth();
                view.setTranslationX(x);
            }
        });

        return animator;
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return super.onDisappear(sceneRoot, view, startValues, endValues);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        // ALPHA
        endValues.view.setAlpha(0.0f);

        // TRANSLATE
        endValues.view.setTranslationX(endValues.view.getMeasuredWidth());

        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
