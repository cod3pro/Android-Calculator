package com.example.borhan.calculator;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tx;
    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    String numbers = "";

    public void doCalculate(View view){
        tx = (TextView) findViewById(R.id.textView);
        numbers = getResources().getResourceEntryName(view.getId());



        switch (numbers) {
            case "num0":
                tx.append("0");
                break;
            case "num1":
                tx.append("1");
                break;
            case "num2":
                tx.append("2");
                break;
            case "num3":
                tx.append("3");
                break;
            case "num4":
                tx.append("4");
                break;
            case "num5":
                tx.append("5");
                break;
            case "num6":
                tx.append("6");
                break;
            case "num7":
                tx.append("7");
                break;
            case "num8":
                tx.append("8");
                break;
            case "num9":
                tx.append("9");
                break;
            case "backButton":
                if(tx.getText().length() <= 0){

                }
                else {
                    CharSequence charSequence = tx.getText().subSequence(0, tx.getText().length()-1);
                    tx.setText(charSequence+"");
                }

                break;
            case "symbolplus":
                if(tx.getText().length()-1 != -1) {
                    char check = tx.getText().charAt(tx.getText().length() - 1);
                    if (check == '+'||check == '-'||check == 'x'||check == '÷') {
                        CharSequence charSequence1 = tx.getText().subSequence(0, tx.getText().length()-1);
                        numbers = charSequence1 + "+";
                        tx.setText(numbers);
                    } else {
                        tx.append("+");
                    }
                }
                break;
            case "symbolminus":
                if(tx.getText().length()-1 != -1) {
                    char check = tx.getText().charAt(tx.getText().length() - 1);
                    if (check == '+'||check == '-'||check == 'x'||check == '÷') {
                        CharSequence charSequence2 = tx.getText().subSequence(0, tx.getText().length()-1);
                        numbers = charSequence2 + "-";
                        tx.setText(numbers);
                    } else {
                        tx.append("-");
                    }
                }
                break;
            case "symboltimes":
                if(tx.getText().length()-1 != -1) {
                    char check = tx.getText().charAt(tx.getText().length() - 1);
                    if (check == '+'||check == '-'||check == 'x'||check == '÷') {
                        CharSequence charSequence3 = tx.getText().subSequence(0, tx.getText().length()-1);
                        numbers = charSequence3 + "*";
                        tx.setText(numbers);
                    } else {
                        tx.append("*");
                    }
                }
                break;
            case "symboldivide":
                if(tx.getText().length()-1 != -1) {
                    char check = tx.getText().charAt(tx.getText().length() - 1);
                    if (check == '+'||check == '-'||check == 'x'||check == '÷') {
                        CharSequence charSequence4 = tx.getText().subSequence(0, tx.getText().length()-1);
                        numbers = charSequence4 + "÷";
                        tx.setText(numbers);
                    } else {
                        tx.append("÷");
                    }
                }
                break;
            case "symbolp1":
                tx.append("(");
                break;
            case "symbolp2":
                tx.append(")");
                break;
            case "sin":
                tx.append("sin");
                break;
            case "cos":
                tx.append("cos");
                break;
            case "tan":
                tx.append("tan");
                break;
            case "pi":
                tx.append("π");
                break;
            case "factorial":
                tx.append("!");
                break;
            case "clearAll":
                if(tx.getText().length() <= 0){

                }
                else {
                    tx.setText("");
                    tx1.setText("");
                }

                break;
            case "symbolequal":
                basicCalculation(tx.getText().toString());
                break;
            case "symboldot":
                tx.append(".");
                break;

        }



    }



    List<String> templist = null;


    public void basicCalculation(String s) {
        tx1 = (TextView) findViewById(R.id.textView2);
        tx1.setText(s);
        double total = 0;
        double allTotal = 0;
        double num1 = 0;
        String sign;
        String[] tokens;

        for (int count = 0; count < s.length() - 1; count++) {
            //templist = Arrays.asList(s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"));
            //templist = Arrays.asList(s.split("(?=\\+)(\\d+\\.\\d+)|(?<=\\d+\\.\\d+)(?=\\+)|(?<=\\+)(?=\\d)|(?<=\\d)(?=\\+)"));

            //templist = Arrays.asList(s.split("(?<=\\+)|(?=\\+)")); //original and working one


            templist = Arrays.asList(s.split("(?<=(-|\\+|\\*|\\÷))|(?=(-|\\+|\\*|\\÷))"));
        }

        sign = "";
        allTotal = Double.parseDouble(templist.get(0));

        DecimalFormat df = new DecimalFormat("0.00");




        for(int i=1; i < templist.size(); i++){

            if((templist.get(i).matches("\\d*|\\d*\\.\\d*")))
            {
                //num1 = Integer.parseInt(templist.get(i));
                num1 = Double.parseDouble(templist.get(i));

                switch (sign){
                    case "+":
                        allTotal += num1;
                        allTotal = Double.parseDouble(df.format(allTotal).replaceAll("\\.00$", ""));

                        break;
                    case "-":
                        allTotal -= num1;
                        allTotal = Double.parseDouble(df.format(allTotal).replaceAll("\\.00$", ""));

                        break;
                    case "*":
                        allTotal *= num1;
                        allTotal = Double.parseDouble(df.format(allTotal).replaceAll("\\.00$", ""));

                        break;
                    case "÷":
                        allTotal /= num1;
                        allTotal = Double.parseDouble(df.format(allTotal).replaceAll("\\.00$", ""));

                        break;

                }
            }
            else
            {
                sign = templist.get(i);
            }
        }

        tx1.setText(allTotal+"");

    }

}
