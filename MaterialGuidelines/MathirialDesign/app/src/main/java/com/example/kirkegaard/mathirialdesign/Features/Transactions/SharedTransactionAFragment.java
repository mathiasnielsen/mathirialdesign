package com.example.kirkegaard.mathirialdesign.Features.Features.Transactions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kirkegaard.mathirialdesign.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SharedTransactionAFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SharedTransactionAFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SharedTransactionAFragment extends Fragment {

    public static final String TAG = SharedTransactionAFragment.class.getSimpleName();

    public SharedTransactionAFragment() {
        // Required empty public constructor
    }

    public static SharedTransactionAFragment newInstance() {
        return new SharedTransactionAFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shared_transaction_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.fragment_a_imageView);

        Button button = (Button) view.findViewById(R.id.fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedTransactionBFragment simpleFragmentB = SharedTransactionBFragment.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
                        .addToBackStack(TAG)
                        .replace(R.id.content, simpleFragmentB)
                        .commit();
            }
        });
    }
}
