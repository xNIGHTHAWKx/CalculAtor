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
    Button plusButton, subButton, timesButton, byButton, equalButton, dotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        resultView = (TextView) findViewById(R.id.result_view);
        resultView.setKeyListener(null);

        plusButton = (Button) findViewById(R.id.plusButton);
        subButton = (Button) findViewById(R.id.subButton);
        timesButton = (Button) findViewById(R.id.timesButton);
        byButton = (Button) findViewById(R.id.byButton);
        equalButton = (Button) findViewById(R.id.equalButton);
        dotButton = (Button) findViewById(R.id.dotButton);

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
            blockButtons();
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

    public void blockButtons() {
        plusButton.setEnabled(false);
        subButton.setEnabled(false);
        timesButton.setEnabled(false);
        byButton.setEnabled(false);
        equalButton.setEnabled(false);
        dotButton.setEnabled(false);
    }

    public void unblockButtons() {
        plusButton.setEnabled(true);
        subButton.setEnabled(true);
        timesButton.setEnabled(true);
        byButton.setEnabled(true);
        equalButton.setEnabled(true);
        dotButton.setEnabled(true);
    }

    public void button1Clicked(View view) {
        resultBuilder.append("1");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button2Clicked(View view) {
        resultBuilder.append("2");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button3Clicked(View view) {
        resultBuilder.append("3");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button4Clicked(View view) {
        resultBuilder.append("4");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button5Clicked(View view) {
        resultBuilder.append("5");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button6Clicked(View view) {
        resultBuilder.append("6");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button7Clicked(View view) {
        resultBuilder.append("7");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button8Clicked(View view) {
        resultBuilder.append("8");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button9Clicked(View view) {
        resultBuilder.append("9");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

    public void button0Clicked(View view) {
        resultBuilder.append("0");
        refresh();
        if (valueOne == 0.0) unblockButtons();
        else equalButton.setEnabled(true);
    }

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

        unblockButtons();
    }

    public void plusButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("+");
        refresh();
        blockButtons();
    }

    public void subButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("-");
        refresh();
        blockButtons();
    }

    public void timesButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("*");
        refresh();
        blockButtons();
    }

    public void byButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("/");
        refresh();
        blockButtons();
    }

    public void allClearButtonClicked(View view) {
        resultBuilder.delete(0, resultBuilder.length());
        refresh();
    }

    public void clearButtonClicked(View view) {
        if (!(resultBuilder.toString().equals(""))) {
            resultBuilder.deleteCharAt(resultBuilder.length() - 1);
            refresh();
        }
    }

    public void signChangeClicked(View view) {
        if (resultView.getText().length() != 0) {
            char operationSign = (resultView.getText() + "").charAt(firstValueLength);
            if (operationSign != '*' && operationSign != '/') {
                if (valueOne == 0.0) {
                    if (resultBuilder.charAt(0) == '-') resultBuilder.deleteCharAt(0);
                    else {
                        String tmp = resultBuilder.toString();
                        resultBuilder = new StringBuilder("-");
                        resultBuilder.append(tmp);
                    }
                } else {
                    String tmp = resultBuilder.toString();
                    resultBuilder = new StringBuilder(tmp.substring(0, firstValueLength));
                    if (tmp.charAt(firstValueLength) == '+') resultBuilder.append("-");
                    else if (tmp.charAt(firstValueLength) == '-') resultBuilder.append("+");
                    else {
                    }
                    resultBuilder.append(tmp.substring(firstValueLength + 1, tmp.length()));
                }
                refresh();
            }
        }
    }

    public void clearResult() { resultBuilder.delete(0, resultBuilder.length()); refresh();}
}
