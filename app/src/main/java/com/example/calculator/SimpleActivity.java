package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleActivity extends AppCompatActivity {

    StringBuilder resultBuilder;
    TextView resultView;
    int firstValueLength;
    double valueOne, valueTwo;
    //Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
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

    public void equalClicked(View view) {
        char operationSign = (resultView.getText() + "").charAt(firstValueLength);
        valueTwo = Double.parseDouble((resultView.getText() + "").substring(firstValueLength+1));
        clearResult();
        switch (operationSign) {
            case '+': {
                double result = valueOne + valueTwo;
                String tmp;
                if(String.valueOf(result).substring(String.valueOf(result).length()-1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length()-2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            } break;

            case '-': {
                double result = valueOne - valueTwo;
                String tmp;
                if(String.valueOf(result).substring(String.valueOf(result).length()-1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length()-2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            } break;

            case '*': {
                double result = valueOne * valueTwo;
                String tmp;
                if(String.valueOf(result).substring(String.valueOf(result).length()-1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length()-2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            } break;

            case '/': {
                double result = valueOne / valueTwo;
                String tmp;
                if(String.valueOf(result).substring(String.valueOf(result).length()-1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length()-2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            } break;
        }
    }

    public void plusButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("+");
        refresh();
    }

    public void subButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("-");
        refresh();}

    public void timesButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("*");
        refresh();
    }

    public void byButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("/");
        refresh();}

    public void allClearButtonClicked(View view) { resultBuilder.delete(0, resultBuilder.length()); refresh();}

    public void clearButtonClicked(View view) { resultBuilder.deleteCharAt(resultBuilder.length()-1); refresh();}

    public void clearResult() { resultBuilder.delete(0, resultBuilder.length()); refresh();}
}
