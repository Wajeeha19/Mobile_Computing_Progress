package org.haqnawaz.kidsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Alphabets extends AppCompatActivity {
    String[] alphabets;
    TextView textView1;
    ImageView imageView1;
    MediaPlayer mp;
    int index;
    private int getIndex(String a) {
        for (int i = 0; i < alphabets.length; i++)
            if (alphabets[i].equals(a))
                return i;
        return -1;
    }
    protected void onResume(){
        super.onResume();
    }
    protected void onStop(){
        super.onStop();
    }
    protected void onDestroy(){
        super.onDestroy();
    }
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("value",index);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
        alphabets= new String[]{"A a", "B b", "C c", "D d", "E e", "F f", "G g", "H h", "I i", "J j", "K k", "L l", "M m", "N n", "O o", "P p", "Q q", "R r", "S s", "T t", "U u", "V v", "W w", "X x", "Y y", "Z z"};
        textView1 = (TextView)findViewById(R.id.textView1);
        imageView1=findViewById(R.id.imageView);
        if(savedInstanceState!=null)
            index = savedInstanceState.getInt("value");
        else
            index=0;
        textView1.setText(alphabets[index]);
        getAlphabetAudio(alphabets[index]);
        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            textView1.animate().translationY(330).setDuration(500);
        else
            textView1.animate().translationY(170).setDuration(500);
        mp.start();
    }

    public void PreviousAlphabet(View view) {
        if(mp.isPlaying())
            mp.release();
        String currentAlphabet = textView1.getText().toString();
        if (!currentAlphabet.equals("A a")) {
            textView1.animate().translationX(-750).setDuration(300);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                int newIndex = getIndex(currentAlphabet)-1;
                if (newIndex >= 0 && newIndex < alphabets.length) {
                    index=newIndex;
                    getAlphabetAudio(alphabets[index]);
                    textView1.setText(alphabets[index]);
                    textView1.animate().translationX(0).setDuration(500);
                    if(!mp.isPlaying())
                        mp.start();
                }
            }, 300);
        }
    }

    public void NextAlphabet(View view) {
        if(mp.isPlaying())
            mp.release();
        String currentAlphabet = textView1.getText().toString();
        if (!currentAlphabet.equals("Z z")) {
            textView1.animate().translationX(750).setDuration(300);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                int newIndex = getIndex(currentAlphabet)+1;
                if (newIndex >= 0 && newIndex < alphabets.length) {
                    index=newIndex;
                    getAlphabetAudio(alphabets[index]);
                    textView1.setText(alphabets[index]);
                    textView1.animate().translationX(0).setDuration(500);
                    if(!mp.isPlaying())
                        mp.start();
                }
            }, 300);
        }
    }
    private void getAlphabetAudio(String alphabet){
        switch (alphabet) {
            case "A a":
                mp=MediaPlayer.create(this,R.raw.a);
                break;
            case "B b":
                mp=MediaPlayer.create(this,R.raw.b);
                break;
            case "C c":
                mp=MediaPlayer.create(this,R.raw.c);
                break;
            case "D d":
                mp=MediaPlayer.create(this,R.raw.d);
                break;
            case "E e":
                mp=MediaPlayer.create(this,R.raw.e);
                break;
            case "F f":
                mp=MediaPlayer.create(this,R.raw.f);
                break;
            case "G g":
                mp=MediaPlayer.create(this,R.raw.g);
                break;
            case "H h":
                mp=MediaPlayer.create(this,R.raw.h);
                break;
            case "I i":
                mp=MediaPlayer.create(this,R.raw.i);
                break;
            case "J j":
                mp=MediaPlayer.create(this,R.raw.j);
                break;
            case "K k":
                mp=MediaPlayer.create(this,R.raw.k);
                break;
            case "L l":
                mp=MediaPlayer.create(this,R.raw.l);
                break;
            case "M m":
                mp=MediaPlayer.create(this,R.raw.m);
                break;
            case  "N n":
                mp=MediaPlayer.create(this,R.raw.n);
                break;
            case  "O o":
                mp=MediaPlayer.create(this,R.raw.o);
                break;
            case  "P p":
                mp=MediaPlayer.create(this,R.raw.p);
                break;
            case  "Q q":
                mp=MediaPlayer.create(this,R.raw.q);
                break;
            case  "R r":
                mp=MediaPlayer.create(this,R.raw.r);
                break;
            case  "S s":
                mp=MediaPlayer.create(this,R.raw.s);
                break;
            case  "T t":
                mp=MediaPlayer.create(this,R.raw.t);
                break;
            case  "U u":
                mp=MediaPlayer.create(this,R.raw.u);
                break;
            case  "V v":
                mp=MediaPlayer.create(this,R.raw.v);
                break;
            case  "W w":
                mp=MediaPlayer.create(this,R.raw.w);
                break;
            case  "X x":
                mp=MediaPlayer.create(this,R.raw.x);
                break;
            case  "Y y":
                mp=MediaPlayer.create(this,R.raw.y);
                break;
            case  "Z z":
                mp=MediaPlayer.create(this,R.raw.z);
                break;
        }
    }
}