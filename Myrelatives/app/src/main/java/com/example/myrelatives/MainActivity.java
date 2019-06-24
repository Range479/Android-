package com.example.myrelatives;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGetRelatives(View view){
        TextView t = (TextView) findViewById(R.id.textview2);
        Spinner s1 = (Spinner) findViewById(R.id.color1);
        Spinner s2 = (Spinner) findViewById(R.id.color2);
        String st1 = String.valueOf(s1.getSelectedItem());
        String st2 = String.valueOf(s2.getSelectedItem());
        t.setText(GetRelatives.getRelatives(st1, st2));
    }
}
