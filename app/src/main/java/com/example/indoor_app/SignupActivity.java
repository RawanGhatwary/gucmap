package com.example.indoor_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private Button signup;
    private TextView havinganaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup=(Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent1);
            }
        });

        havinganaccount=(TextView) findViewById(R.id.havinganaccount);
        havinganaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(SignupActivity.this,SigninActivity.class);
                startActivity(intent2);
            }
        });
    }
}
