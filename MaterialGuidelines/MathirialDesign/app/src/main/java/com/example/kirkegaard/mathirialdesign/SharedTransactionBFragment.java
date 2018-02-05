package com.example.kirkegaard.mathirialdesign;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SharedTransactionBFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SharedTransactionBFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SharedTransactionBFragment extends Fragment {

    public SharedTransactionBFragment() {
        // Required empty public constructor
    }

    public static SharedTransactionBFragment newInstance() {
        return new SharedTransactionBFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            TransitionInflater transInflater = TransitionInflater.from(getContext());
            Transition trans = transInflater.inflateTransition(android.R.transition.move);
            setSharedElementEnterTransition(trans);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shared_transaction_b, container, false);
    }
}
