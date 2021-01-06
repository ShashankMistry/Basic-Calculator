package com.shashank.calculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class pageAdapter extends FragmentStatePagerAdapter {
    private final int numOfTabs;


    public pageAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm, numOfTabs);
        this.numOfTabs = numOfTabs;
    }
    
    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new CalculatorFragment();
            case 1:
                return new HistoryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
