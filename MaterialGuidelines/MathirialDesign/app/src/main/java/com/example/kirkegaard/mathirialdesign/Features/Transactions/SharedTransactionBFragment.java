package com.example.kirkegaard.mathirialdesign.Features.Transactions;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kirkegaard.mathirialdesign.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SharedTransactionBFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SharedTransactionBFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SharedTransactionBFragment extends Fragment {

    private static int _counter;

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
            //setSharedElementEnterTransition(trans);
        }

        _counter++;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_shared_transaction_b, container, false);

        final ImageView imageView = (ImageView) view.findViewById(R.id.fragment_b_image);

        Button button = (Button) view.findViewById(R.id.fragment_b_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedTransactionAFragment simpleFragment = SharedTransactionAFragment.newInstance();
                SharedTransactionBFragment simpleFragment = SharedTransactionBFragment.newInstance();

                int targetId = R.id.fragment_b_btn;
                TransHelper.AddCustomTransition(simpleFragment, targetId);

                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
                        .addToBackStack(SharedTransactionAFragment.TAG)
                        .replace(R.id.content, simpleFragment)
                        .commit();

                TransitionInflater transInflater = TransitionInflater.from(getContext());
                Transition trans = transInflater.inflateTransition(android.R.transition.fade);
                simpleFragment.setSharedElementEnterTransition(trans);
                simpleFragment.setSharedElementReturnTransition(trans);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
