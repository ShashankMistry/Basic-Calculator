package com.shashank.calculator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import androidx.lifecycle.ViewModelProviders;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class HistoryFragment extends Fragment {
    ArrayList<HistoryList> historyLists;
    SharedViewModel viewModel;
    String History;
    ListView listView;
    Button btnClear;
    View rootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_history, container, false);
        btnClear = rootView.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> listView.setAdapter(null));
        historyLists = new ArrayList<>();
        return rootView;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), charSequence -> {
            History = String.valueOf(charSequence);
            String[] HistoryArray = History.split("=");
            String[] RemoveDot = HistoryArray[1].split("\\.");
            if(RemoveDot.length>1){
                if(RemoveDot[1].equals("0")){
                    HistoryArray[1]=RemoveDot[0];
                }
            }
            if (History.split("=").length == 2) {
                historyLists.add(new HistoryList(HistoryArray[0], HistoryArray[1]));
                HistoryAdapter adapter = new HistoryAdapter(Objects.requireNonNull(getActivity()), historyLists);
                Collections.reverse(historyLists);
                listView = rootView.findViewById(R.id.history);
                listView.setAdapter(adapter);
            }

        });
    }
}
