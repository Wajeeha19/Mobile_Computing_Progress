package org.haqnawaz.mc04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ALC2","onResume called");
    }
    protected void onStop(){
        super.onStop();
        Log.d("ALC2","onStop called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ALC2","onDestroy called");
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("ALC2","onCreate called");
    }
    public void MoveToActivity3(View view){
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}