package com.rca.bottomnavigationview.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rca.bottomnavigationview.R;

public class FiveFragment extends Fragment {

    private TextView tvMessage;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_five, null, false);

        Log.d("Fragment", "Five - saved: " + (savedInstanceState != null));

        return view;
    }
}