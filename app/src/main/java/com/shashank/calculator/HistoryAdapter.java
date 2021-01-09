package com.shashank.calculator;

import android.content.Context;
import android.util.TypedValue;
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
    TextView tvEquation;
    TextView tvAns;
    String Calc;
    String Ans;


    public HistoryAdapter(@NonNull Context context, @NonNull List<HistoryList> objects) {
        super(context, 0, objects);
        this.mContext = context;
    }

    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        Calc = Objects.requireNonNull(getItem(position)).getCalculation();
        Ans = Objects.requireNonNull(getItem(position)).getAnswer();
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.history_list, parent, false);
        }
         tvEquation = convertView.findViewById(R.id.calc);
         tvAns = convertView.findViewById(R.id.answer);
         CalSize();
         AnsSize();
         tvEquation.setText(Calc);
         tvAns.setText(Ans);
        return convertView;
    }
    public void CalSize() {
        if (Calc.length() > 18) {
            tvEquation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        } else if (Calc.length() > 15) {
            tvEquation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (Calc.length() > 11) {
            tvEquation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        } else if (Calc.length() > 1) {
            tvEquation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        }
    }

    public void AnsSize() {
        if (Ans.length() > 19) {
            tvAns.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        } else if (Ans.length() > 14) {
            tvAns.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (Ans.length() > 12) {
            tvAns.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        } else if (Ans.length() > 8) {
            tvAns.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
        }
    }
}
