package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdvancedActivity extends AppCompatActivity {

    StringBuilder resultBuilder;
    TextView resultView;
    int firstValueLength;
    double valueOne, valueTwo;
    boolean buttonsBlocked;
    boolean dotBlocked;
    Button equalButton, plusButton, subButton, timesButton, byButton, logButton, lnButton,
    toPowOfYButton, toSquareButton, tanButton, cosButton, sinButton, sqrtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        resultView = (TextView) findViewById(R.id.result_view);
        resultView.setKeyListener(null);

        equalButton = (Button) findViewById(R.id.equalButton);
        plusButton = (Button) findViewById(R.id.plusButton);
        subButton = (Button) findViewById(R.id.subButton);
        timesButton = (Button) findViewById(R.id.timesButton);
        byButton = (Button) findViewById(R.id.byButton);
        logButton = (Button) findViewById(R.id.logButton);
        lnButton = (Button) findViewById(R.id.lnButton);
        toPowOfYButton = (Button) findViewById(R.id.toPowOfYButton);
        toSquareButton = (Button) findViewById(R.id.squareButton);
        tanButton = (Button) findViewById(R.id.tanButton);
        cosButton = (Button) findViewById(R.id.cosButton);
        sinButton = (Button) findViewById(R.id.sinButton);
        sqrtButton = (Button) findViewById(R.id.sqrtButton);

        if (savedInstanceState != null) {
            resultBuilder = new StringBuilder(savedInstanceState.getString("Result"));
            firstValueLength = savedInstanceState.getInt("Length");
            valueOne = savedInstanceState.getDouble("ValueOne");
            valueTwo = savedInstanceState.getDouble("ValueTwo");
            buttonsBlocked = savedInstanceState.getBoolean("Block");
            dotBlocked = savedInstanceState.getBoolean("DotBlock");
            if (buttonsBlocked) {
                blockButtons();
                equalButton.setEnabled(true);
            }
            refresh();
        } else {
            resultBuilder = new StringBuilder("");
            firstValueLength = 0;
            valueOne = 0.0;
            valueTwo = 0.0;
            refresh();
            dotBlocked = false;
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
        savedInstanceState.putBoolean("Block", buttonsBlocked);
        savedInstanceState.putBoolean("DotBlock", dotBlocked);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void blockButtons() {
        equalButton.setEnabled(false);
        plusButton.setEnabled(false);
        subButton.setEnabled(false);
        timesButton.setEnabled(false);
        byButton.setEnabled(false);
        logButton.setEnabled(false);
        lnButton.setEnabled(false);
        toPowOfYButton.setEnabled(false);
        toSquareButton.setEnabled(false);
        tanButton.setEnabled(false);
        cosButton.setEnabled(false);
        sinButton.setEnabled(false);
        sqrtButton.setEnabled(false);
        buttonsBlocked = true;
    }

    public void unlockButtons() {
        equalButton.setEnabled(true);
        plusButton.setEnabled(true);
        subButton.setEnabled(true);
        timesButton.setEnabled(true);
        byButton.setEnabled(true);
        logButton.setEnabled(true);
        lnButton.setEnabled(true);
        toPowOfYButton.setEnabled(true);
        toSquareButton.setEnabled(true);
        tanButton.setEnabled(true);
        cosButton.setEnabled(true);
        sinButton.setEnabled(true);
        sqrtButton.setEnabled(true);
        buttonsBlocked = false;
    }

    public void refresh() {
        resultView.setText(resultBuilder);
    }

    public void button1Clicked(View view) {
        resultBuilder.append("1");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button2Clicked(View view) {
        resultBuilder.append("2");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button3Clicked(View view) {
        resultBuilder.append("3");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button4Clicked(View view) {
        resultBuilder.append("4");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button5Clicked(View view) {
        resultBuilder.append("5");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button6Clicked(View view) {
        resultBuilder.append("6");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button7Clicked(View view) {
        resultBuilder.append("7");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button8Clicked(View view) {
        resultBuilder.append("8");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button9Clicked(View view) {
        resultBuilder.append("9");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void button0Clicked(View view) {
        resultBuilder.append("0");
        refresh();
        if(valueOne == 0) unlockButtons();
        else equalButton.setEnabled(true);
    }

    public void dotButtonClicked(View view) {
        if (!dotBlocked) {
            resultBuilder.append(".");
            refresh();
            dotBlocked = true;
        }
    }

    public void equalClicked(View view) {
        boolean divisionByZero = false;

        char operationSign = (resultView.getText() + "").charAt(firstValueLength);
        valueTwo = Double.parseDouble((resultView.getText() + "").substring(firstValueLength + 1));
        clearResult();
        switch (operationSign) {
            case '+': {
                double result = valueOne + valueTwo;
                String tmp;
                if (String.valueOf(result).substring(String.valueOf(result).length() - 1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length() - 2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            }
            break;

            case '-': {
                double result = valueOne - valueTwo;
                String tmp;
                if (String.valueOf(result).substring(String.valueOf(result).length() - 1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length() - 2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            }
            break;

            case '*': {
                double result = valueOne * valueTwo;
                String tmp;
                if (String.valueOf(result).substring(String.valueOf(result).length() - 1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length() - 2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            }
            break;

            case '/': {
                if (valueTwo != 0.0) {
                    double result = valueOne / valueTwo;
                    String tmp;
                    if (String.valueOf(result).substring(String.valueOf(result).length() - 1).equals("0")) {
                        tmp = String.valueOf(result).substring(0, String.valueOf(result).length() - 2);
                    } else tmp = String.valueOf(result);
                    resultBuilder = new StringBuilder(tmp);
                    refresh();
                } else {
                    Toast.makeText(getApplicationContext(), "You can't divide by zero!", Toast.LENGTH_LONG).show();
                    blockButtons();
                    divisionByZero = true;
                }
            }
            break;

            case '^': {
                double result = Math.pow(valueOne, valueTwo);
                String tmp;
                if (String.valueOf(result).substring(String.valueOf(result).length() - 1).equals("0")) {
                    tmp = String.valueOf(result).substring(0, String.valueOf(result).length() - 2);
                } else tmp = String.valueOf(result);
                resultBuilder = new StringBuilder(tmp);
                refresh();
            }
            break;
        }

        if (!divisionByZero) unlockButtons();
        firstValueLength = 0;
        valueOne = 0.0;
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
        unlockButtons();
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
                    else if (tmp.charAt(firstValueLength) == '^') resultBuilder.append("^-");
                    resultBuilder.append(tmp.substring(firstValueLength+1, tmp.length()));
                }
                refresh();
            }
        }
    }

    public void clearResult() {
        resultBuilder.delete(0, resultBuilder.length());
        refresh();
    }

    //Advanced functionality below

    public void toTheSquareButtonClicked(View view) {
        double value = Double.parseDouble(resultBuilder.toString());
        double valueSquared = value * value;
        String tmp;
        if (String.valueOf(valueSquared).substring(String.valueOf(valueSquared).length() - 1).equals("0")) {
            tmp = String.valueOf(valueSquared).substring(0, String.valueOf(valueSquared).length() - 2);
        } else tmp = String.valueOf(valueSquared);
        resultBuilder = new StringBuilder(tmp);
        refresh();
    }

    public void toThePowerOfYButtonClicked(View view) {
        firstValueLength = resultView.length();
        valueOne = Double.parseDouble(resultView.getText() + "");
        resultBuilder.append("^");
        refresh();
        blockButtons();
    }

    public void sqrtButtonClicked(View view) {
        double value = Math.sqrt(Double.valueOf(resultBuilder.toString()));
        if (value > 0) {
            String tmp;
            if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
                tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
            } else tmp = String.valueOf(value);
            resultBuilder = new StringBuilder(tmp);
            refresh();
        } else Toast.makeText(getApplicationContext(), "You can't make sqrt of negative number!", Toast.LENGTH_LONG).show();

    }

    public void naturalLogarithmButtonClicked(View view) {
        double value = Math.log(Double.valueOf(resultBuilder.toString()));
        if (value > 0) {
            String tmp;
            if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
                tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
            } else tmp = String.valueOf(value);
            resultBuilder = new StringBuilder(tmp);
            refresh();
        } else Toast.makeText(getApplicationContext(), "You can't make natural logarithm of negative number!", Toast.LENGTH_LONG).show();
    }

    public void decimalLogarithmButtonClicked(View view) {
        double value = Math.log10(Double.valueOf(resultBuilder.toString()));
        if (value > 0) {
            String tmp;
            if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
                tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
            } else tmp = String.valueOf(value);
            resultBuilder = new StringBuilder(tmp);
            refresh();
        } else Toast.makeText(getApplicationContext(), "You can't make decimal logarithm of negative number!", Toast.LENGTH_LONG).show();
    }

    public void sinusButtonClicked(View view) {
        double value = Math.sin(Double.valueOf(resultBuilder.toString()));
        String tmp;
        if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
            tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
        } else tmp = String.valueOf(value);
        resultBuilder = new StringBuilder(tmp);
        refresh();
    }

    public void cosinusButtonClicked(View view) {
        double value = Math.cos(Double.valueOf(resultBuilder.toString()));
        String tmp;
        if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
            tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
        } else tmp = String.valueOf(value);
        resultBuilder = new StringBuilder(tmp);
        refresh();
    }

    public void tangensButtonClicked(View view) {
        double value = Math.tan(Double.valueOf(resultBuilder.toString()));
        String tmp;
        if (String.valueOf(value).substring(String.valueOf(value).length() - 1).equals("0")) {
            tmp = String.valueOf(value).substring(0, String.valueOf(value).length() - 2);
        } else tmp = String.valueOf(value);
        resultBuilder = new StringBuilder(tmp);
        refresh();
    }
}
