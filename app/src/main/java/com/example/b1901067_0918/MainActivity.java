package com.example.b1901067_0918;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNew, btnCall;
    TextView tvResult;
    EditText edtNum1, edtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),
                "MainActivity onCreate", Toast.LENGTH_SHORT).show();

        btnNew = (Button) findViewById(R.id.btnNew);
        btnCall = (Button) findViewById(R.id.btnCall);
        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        tvResult = (TextView) findViewById(R.id.tvResult);

        ActivityResultLauncher activityResultLauncher;
        activityResultLauncher = registerForActivityResult(new
                ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == RESULT_OK){
                Integer resultValue = result.getData().getIntExtra("Result",0);
                tvResult.setText("연산결과 : " + resultValue.toString());
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                //startActivityForResult(intent, 0); 보안 문제로 현제 코드 대신 엑티비티런쳐코드를 사용한다.
                activityResultLauncher.launch(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tell:/119"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),
                "MainActivity onStart", Toast.LENGTH_SHORT).show();
        edtNum1.setText("");
        edtNum2.setText("");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),
                "MainActivity onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),
                "MainActivity onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),
                "MainActivity onPause", Toast.LENGTH_SHORT).show();
    }
    //보안 문제로 아래의 코드 대신 엑티비티런쳐코드를 사용한다.
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Integer resultValue = data.getIntExtra("Result",0);
            tvResult.setText("연산결과 : " + resultValue.toString());
        }
    }
    */
}