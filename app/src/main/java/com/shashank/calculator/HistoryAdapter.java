package com.shashank.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;

public class HistoryAdapter extends ArrayAdapter<HistoryList> {
    private final Context mContext;


    public HistoryAdapter(@NonNull Context context, @NonNull List<HistoryList> objects) {
        super(context, 0, objects);
        this.mContext = context;
    }

    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        String Calc = Objects.requireNonNull(getItem(position)).getCalculation();
        String Ans = Objects.requireNonNull(getItem(position)).getAnswer();
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.history_list, parent, false);
        }
         TextView tvCalc = convertView.findViewById(R.id.calc);
         TextView tvAns = convertView.findViewById(R.id.answer);
         tvCalc.setText(Calc);
         tvAns.setText(Ans);
        return convertView;
    }
}
