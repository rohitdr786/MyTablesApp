package com.example.rohit.mytablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=(SeekBar) findViewById(R.id.mySeekBar);
        final ListView listView=(ListView) findViewById(R.id.myTable);
        final ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,changeTable(1));
        listView.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                arrayAdapter.clear();
                arrayAdapter.addAll(changeTable(progress));
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public List<Integer> changeTable(int num){
        List<Integer> table=new ArrayList<>();
        for(int i=1;i<=10;i++){
            table.add(num*i);
        }
        return table;
    }


}
