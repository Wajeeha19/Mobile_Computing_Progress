package org.haqnawaz.mc04;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView textview;
    Button button;
    int count=0;
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ALC","onResume called");
    }
    protected void onStop(){
        super.onStop();
        Log.d("ALC","onStop called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ALC","onDestroy called");
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("value",count);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonCount);
        textview=findViewById(R.id.textViewCounter);

    }
    public void Counter(View view) {
        count=Integer.parseInt(textview.getText().toString());
        count++;
        textview.setText(String.valueOf(count));
    }
    public void MoveToActivity2(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void MoveToActivity3(View view) {
        Intent intent=new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}