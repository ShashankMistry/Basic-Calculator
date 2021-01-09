package com.shashank.calculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class HistoryFragment extends Fragment {
    ArrayList<HistoryList> historyLists;
    HistoryAdapter adapter;
    SharedViewModel viewModel;
    String History;
    ListView listView;
    Button btnClear;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_history, container, false);
        btnClear = rootView.findViewById(R.id.btnClear);
        listView = rootView.findViewById(R.id.history);
        Vibrator vibe = (Vibrator) Objects.requireNonNull(getActivity()).getSystemService(Context.VIBRATOR_SERVICE);
        btnClear.setOnClickListener(v -> {
            historyLists.clear();
            listView.setAdapter(null);
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            HistoryList historyList = historyLists.get(position);
            String ans = historyList.getAnswer();
            vibe.vibrate(10);
            ClipboardManager clipboard = (ClipboardManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("CalcData", ans);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            return false;
        });
        historyLists = new ArrayList<>();
        return rootView;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // getting data from SharedViewModel and setting it to ListView
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), charSequence -> {
            History = String.valueOf(charSequence);
            String[] HistoryArray = History.split("=");
            String[] RemoveDot = HistoryArray[1].split("\\.");
            if (RemoveDot.length > 1) {
                if (RemoveDot[1].equals("0")) {
                    HistoryArray[1] = RemoveDot[0];
                }
            }
            if (History.split("=").length == 2) {
                adapter = new HistoryAdapter(Objects.requireNonNull(getActivity()), historyLists);
                historyLists.add(0,new HistoryList(HistoryArray[0], HistoryArray[1]));
                listView.setAdapter(adapter);
            }
        });
    }
}
