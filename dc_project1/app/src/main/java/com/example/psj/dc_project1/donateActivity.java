package com.example.psj.dc_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class donateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        Button dnbtn1 = (Button)findViewById(R.id.dnbtn1);

        dnbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donateActivity.this,SignActivity.class);
                // 또 다른 액티비티 실행
                startActivityForResult(intent, 0);
            }
        });
    }
}
