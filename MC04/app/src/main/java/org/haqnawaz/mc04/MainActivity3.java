package org.haqnawaz.mc04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {

    protected void onResume(){
        super.onResume();
        Log.d("ALC3","onResume called");
    }
    protected void onStop(){
        super.onStop();
        Log.d("ALC3","onStop called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ALC3","onDestroy called");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("ALC3","onCreate called");
    }
}