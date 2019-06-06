package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public class CustomTransReturn extends Visibility {
    public CustomTransReturn() {
        super();
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, final View view, TransitionValues startValues, TransitionValues endValues) {

        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float)animation.getAnimatedValue();

                // ALPHA
                float alpha = 1.0f - animatedValue;
                view.setAlpha(alpha);

                // TRANSLATE
                float x = animatedValue * view.getMeasuredWidth();
                view.setTranslationX(x);
            }
        });

        return animator;
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {

        View view = startValues.view;

        // ALPHA
        view.setAlpha(1.0f);

        // TRANSLATE
        view.setTranslationX(0);

        return super.createAnimator(sceneRoot, startValues, endValues);
    }
}
