package com.example.b1901067_0918;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button btnBack;
    TextView textView1, textView2;
    EditText edtOper;
    Integer num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(getApplicationContext(),
                "SecondActivity onCreate", Toast.LENGTH_SHORT).show();

        btnBack = (Button) findViewById(R.id.btnBack);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        edtOper = (EditText) findViewById(R.id.edtOper);

        Intent inIntent = getIntent();
        num1 = inIntent.getIntExtra("Num1",0);
        num2 = inIntent.getIntExtra("Num2",0);

        textView1.setText("숫자1 : " + num1.toString());
        textView2.setText("숫자2 : " + num2.toString());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtOper.getText().toString().equals("+")){
                    result = num1 + num2;
                } else if (edtOper.getText().toString().equals("-")) {
                    result = num1 - num2;
                } else if (edtOper.getText().toString().equals("*")) {
                    result = num1 * num2;
                } else if (edtOper.getText().toString().equals("/")) {
                    result = num1 / num2;
                }

                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Result", result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),
                "SecondActivity onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),
                "SecondActivity onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),
                "SecondActivity onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),
                "SecondActivity onPause", Toast.LENGTH_SHORT).show();
    }
}