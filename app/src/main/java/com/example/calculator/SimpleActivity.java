package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {

    StringBuilder resultBuilder;
    TextView resultView;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        resultView = (TextView) findViewById(R.id.result_view);
        resultView.setKeyListener(null);
        if(savedInstanceState != null) {
            resultBuilder = new StringBuilder(savedInstanceState.getString("Result"));
            refresh();
        }
        else {
            resultBuilder = new StringBuilder("");
            refresh();
        }

        button1 = (Button) findViewById(R.id.button1);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
       TextView resultView = (TextView) findViewById(R.id.result_view);
       String tmp = resultView.getText().toString();
       savedInstanceState.putString("Result", tmp);
       super.onSaveInstanceState(savedInstanceState);
    }

    public void refresh() {
        resultView.setText(resultBuilder);
    }

    public void button1Clicked(View view) { resultBuilder.append("1"); refresh();}

    public void button2Clicked(View view) { resultBuilder.append("2"); refresh();}

    public void button3Clicked(View view) { resultBuilder.append("3"); refresh();}

    public void button4Clicked(View view) { resultBuilder.append("4"); refresh();}

    public void button5Clicked(View view) { resultBuilder.append("5"); refresh();}

    public void button6Clicked(View view) { resultBuilder.append("6"); refresh();}

    public void button7Clicked(View view) { resultBuilder.append("7"); refresh();}

    public void button8Clicked(View view) { resultBuilder.append("8"); refresh();}

    public void button9Clicked(View view) { resultBuilder.append("9"); refresh();}

    public void button0Clicked(View view) { resultBuilder.append("0"); refresh();}

    public void dotButtonClicked(View view) { resultBuilder.append("."); refresh();}

    public void equalClicked(View view) { } //TODO

    public void plusButtonClicked(View view) { resultBuilder.append("+"); refresh();}

    public void subButtonClicked(View view) { resultBuilder.append("-"); refresh();}

    public void timesButtonClicked(View view) { resultBuilder.append("*"); refresh();}

    public void byButtonClicked(View view) { resultBuilder.append("/"); refresh();}

    public void allClearButtonClicked(View view) { resultBuilder.delete(0, resultBuilder.length()); refresh();}

    public void clearButtonClicked(View view) { resultBuilder.deleteCharAt(resultBuilder.length()-1); refresh();}
}
