package com.tuanshang.sourcedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tuanshang.sourcedemo.presenter.Mainpresenter;

public class MainActivity extends AppCompatActivity {
    private Mainpresenter mainpresenter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.button);
        mainpresenter = new Mainpresenter(this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainpresenter.getCode("login", "13588088942");
            }
        });
    }
}
