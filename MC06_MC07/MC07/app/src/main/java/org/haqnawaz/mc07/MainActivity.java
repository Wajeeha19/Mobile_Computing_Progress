package org.haqnawaz.mc07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Animation(View view){
        ImageView imageView=findViewById(R.id.imageView);
        /*imageView.animate().alpha(0).setDuration(1000);*/
        /*imageView.animate().translationYBy(500).setDuration(1000);*/
        /*imageView.animate().translationXBy(-300).setDuration(1000);*/
        /*imageView.animate().rotation(180).alpha(0).setDuration(3200);*/
        /*imageView.animate().scaleX(0.6f).;*/
      imageView.animate().scaleX(0.6f).scaleY(0.6f);
    }

    public void AudioActivity(View view) {
        Intent intent=new Intent(this,Audio.class);
        startActivity(intent);
    }

    public void VideoActivity(View view) {
        Intent intent=new Intent(this,Video.class);
        startActivity(intent);
    }
}