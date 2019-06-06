package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;

public class TransHelper {

    public static void AddSlideTransition(Fragment fragment, int target)
    {
        Slide enterTrans = new Slide(Gravity.LEFT);
        AddTarget(enterTrans, target);
        ExcludeTarget(enterTrans, target);
        fragment.setEnterTransition(enterTrans);

        Slide exitTrans = new Slide(Gravity.BOTTOM);
        AddTarget(exitTrans, target);
        ExcludeTarget(exitTrans, target);
        fragment.setExitTransition(exitTrans);

        Slide returnTrans = new Slide(Gravity.TOP);
        AddTarget(returnTrans, target);
        ExcludeTarget(returnTrans, target);
        fragment.setReturnTransition(returnTrans);

        Slide reenterTrans = new Slide(Gravity.RIGHT);
        AddTarget(reenterTrans, target);
        ExcludeTarget(reenterTrans, target);
        fragment.setReenterTransition(reenterTrans);
    }

    public static void AddCustomTransition(Fragment fragment, int target)
    {
        CustomTransEnter enterTrans = new CustomTransEnter();
        AddTarget(enterTrans, target);
        ExcludeTarget(enterTrans, target);
        fragment.setEnterTransition(enterTrans);

        CustomTransExit exitTrans = new CustomTransExit();
        AddTarget(exitTrans, target);
        ExcludeTarget(exitTrans, target);
        fragment.setExitTransition(exitTrans);

        CustomTransReturn returnTrans = new CustomTransReturn();
        AddTarget(returnTrans, target);
        ExcludeTarget(returnTrans, target);
        fragment.setReturnTransition(returnTrans);

        CustomTransReenter reenterTrans = new CustomTransReenter();
        AddTarget(reenterTrans, target);
        ExcludeTarget(reenterTrans, target);
        fragment.setReenterTransition(reenterTrans);
    }

    public static void AddTarget(Transition transition, int resourceId)
    {
        ////transition.addTarget(resourceId);
    }

    public static void ExcludeTarget(Transition transition, int resourceId)
    {
        transition.excludeTarget(resourceId, true);
    }
}
