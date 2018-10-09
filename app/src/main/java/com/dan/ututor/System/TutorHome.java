package com.dan.ututor.System;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.dan.ututor.R;

public class TutorHome {

// pass profiles from database to array
     String[] profiles = new String[1000];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_home);

        ListView listView = (ListView)findViewByID(R.id.listView);

    }

    class CustomAdapter extends BaseAdapter{
@Override
public int getCount(){
    return profiles.length;
}
@Override
        public Object getItem(int i){
    return null;
}
        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }}
    // display interface

    // button clic action events

