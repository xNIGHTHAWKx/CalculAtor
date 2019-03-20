package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdvancedActivity extends AppCompatActivity {

    StringBuilder resultBuilder;
    TextView resultView;
    int firstValueLength;
    double valueOne, valueTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        resultView = (TextView) findViewById(R.id.result_view);
        resultView.setKeyListener(null);
        if(savedInstanceState != null) {
            resultBuilder = new StringBuilder(savedInstanceState.getString("Result"));
            firstValueLength = savedInstanceState.getInt("Length");
            valueOne = savedInstanceState.getDouble("ValueOne");
            valueTwo = savedInstanceState.getDouble("ValueTwo");
            refresh();
        }
        else {
            resultBuilder = new StringBuilder("");
            firstValueLength = 0;
            valueOne = 0.0;
            valueTwo = 0.0;
            refresh();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        TextView resultView = (TextView) findViewById(R.id.result_view);
        String tmp = resultView.getText().toString();
        savedInstanceState.putString("Result", tmp);
        savedInstanceState.putInt("Length", firstValueLength);
        savedInstanceState.putDouble("ValueOne", valueOne);
        savedInstanceState.putDouble("ValueTwo", valueTwo);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void refresh() {
        resultView.setText(resultBuilder);
    }
}
