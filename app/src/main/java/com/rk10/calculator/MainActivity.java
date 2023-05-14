package com.rk10.calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import org.mariuszgromada.math.mxparser.*;
public class MainActivity extends AppCompatActivity {

    Button nine,eight,seven,six,five,four,three,two,one,zero;
    Button clean,sign,percentage,div,multiply,sub,adding,parent,dot,equals;
    EditText preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        preview.setText("");

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("0", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("1", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("2", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("3", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("4", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("5", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("6", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("7", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("8", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("9", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText(".", preview.getText().toString(), pos));
                preview.setSelection(pos + 1);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("÷", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("×", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("-", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("+", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("%", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText(updateText("-", preview.getText().toString(), preview.getSelectionStart()));
                preview.setSelection(pos + 1);
            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = preview.getSelectionStart();
                preview.setText("");
            }
        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursor = preview.getSelectionStart();
                int open = 0;
                int close = 0;
                int textLen = preview.getText().length();

                for (int i = 0; i < preview.getSelectionStart(); i++) {
                    if (preview.getText().toString().substring(i, i + 1).equals("(")) {
                        open += 1;
                    }
                    if (preview.getText().toString().substring(i, i + 1).equals(")")) {
                        close += 1;
                    }
                }
                if (open == close || preview.getText().toString().substring(textLen - 1, textLen).equals("(")) {
                    preview.setText(updateText("(", preview.getText().toString(), preview.getSelectionStart()));
                }
                else if (close < open && !preview.getText().toString().substring(textLen - 1, textLen).equals("(")) {
                    preview.setText(updateText(")", preview.getText().toString(), preview.getSelectionStart()));
                }
                preview.setSelection(cursor + 1);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String expression = preview.getText().toString();
                expression = expression.replaceAll("÷", "/"); //ALT + 0247 for division symbol
                expression = expression.replaceAll("×", "*"); //ALT + 0215 for multiplication symbol

                Expression ex = new Expression(expression);
                String result = String.valueOf(ex.calculate());
                preview.setText(result);
                preview.setSelection(result.length());
            }
        });

    }

    private void setupUI(){
        preview = findViewById(R.id.preview);
        preview.setShowSoftInputOnFocus(false); // I used this to block showing the input screen.


        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);

        clean = (Button) findViewById(R.id.clean);
        parent = (Button) findViewById(R.id.parent);
        percentage = (Button) findViewById(R.id.percentage);
        div = (Button) findViewById(R.id.div);
        multiply = (Button) findViewById(R.id.multiply);
        sub = (Button) findViewById(R.id.sub);
        adding = (Button) findViewById(R.id.adding);
        sign = (Button) findViewById(R.id.sign);
        dot = (Button) findViewById(R.id.dot);
        equals = (Button) findViewById(R.id.equals);

        }

    private String updateText(String strToAdd, String old, int cursor){
        String leftPart = old.substring(0,cursor);
        String rightPart = old.substring(cursor);
        return leftPart + strToAdd + rightPart;
    }

}