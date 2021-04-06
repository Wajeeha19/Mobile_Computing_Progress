package org.haqnawaz.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView.animate().rotationY(360).setDuration(150);
    }
    public void startAlphabets(View view) {
        Intent intent=new Intent(this,Alphabets.class);
        startActivity(intent);
    }
    public void AboutApp(View view) {
        Intent intent=new Intent(this,AppInfo.class);
        startActivity(intent);
    }

}