package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.support.transition.Transition;
import android.support.v4.app.Fragment;
import android.transition.Slide;
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
        ExcludeTarget(enterTrans, target);
        fragment.setExitTransition(exitTrans);

        Slide returnTrans = new Slide(Gravity.TOP);
        AddTarget(returnTrans, target);
        ExcludeTarget(enterTrans, target);
        fragment.setReturnTransition(returnTrans);

        Slide reenterTrans = new Slide(Gravity.RIGHT);
        AddTarget(reenterTrans, target);
        ExcludeTarget(enterTrans, target);
        fragment.setReenterTransition(reenterTrans);

    }

    public static void AddTarget(Slide transition, int resourceId)
    {
        transition.addTarget(resourceId);
    }

    public static void ExcludeTarget(Slide transition, int resourceId)
    {
        ////transition.addTarget(resourceId);
    }
}
