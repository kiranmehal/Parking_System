package com.example.macstudent.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MannualActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mannual);
        myWebView=(WebView)findViewById(R.id.myWebView);
        myWebView.loadUrl("file:///android_asset/instruction.html");
    }
}
