package com.example.intent_extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    Button bt_s01;
    TextView tv_s01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //recupera botão e seta Listener
        bt_s01 = (Button)findViewById(R.id.bt_s01);
        bt_s01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_s01 = (TextView)findViewById(R.id.tv_s01);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null){
            String str = intent.getStringExtra("addr");
            tv_s01.setText(str);
        } else{
            tv_s01.setText("No Message Received!!!");
        }
    }
}
