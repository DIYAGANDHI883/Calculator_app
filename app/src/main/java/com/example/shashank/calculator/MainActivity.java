package com.example.shashank.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    boolean isNewOp=true;
    String oldNumber="";
    String op ="+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editTexts);
    }
    public void onClickNumber(View view){

        if(isNewOp){
            ed1.setText("");
        }
        isNewOp=false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buOne:
                number += "1";
                break;
            case R.id.buTwo:
                number +="2";
                break;
            case R.id.buThree:
                number +="3";
                break;
            case R.id.buFour:
                number +="4";
                break;
            case R.id.buFive:
                number +="5";
                break;
            case R.id.buSix:
                number +="6";
                break;
            case R.id.buSeven:
                number +="7";
                break;
            case R.id.buEight:
                number +="8";
                break;
            case R.id.buNine:
                number +="9";
                break;
            case R.id.buZero:
                number +="0";
                break;
            case R.id.buDot:
                number +=".";
                break;
            case R.id.buPlusMinus:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }
    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber=ed1.getText().toString();
        switch (view.getId()){
            case R.id.buDivide:
                op = "/";
                break;
            case R.id.buMinus:
                op = "-";
                break;
            case R.id.buMulti:
                op = "*";
                break;
            case R.id.buPlus:
                op = "+";
                break;

        }


    }
    public void equalResult(View view){
        String newNumber = ed1.getText().toString();
        double result=0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }
    public void acEvent(View view){
        ed1.setText("0");
        isNewOp=true;
    }
    public void percentEvent(View view){
        double no=Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOp=true;
    }
}