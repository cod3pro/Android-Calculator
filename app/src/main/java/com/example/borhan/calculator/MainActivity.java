package com.example.borhan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void doCalculate(View view){
        tx = (TextView) findViewById(R.id.textView);
        tx.setText(getResources().getResourceEntryName(view.getId()));
    }

}
