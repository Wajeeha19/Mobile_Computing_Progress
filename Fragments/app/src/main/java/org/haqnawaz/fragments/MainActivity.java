package org.haqnawaz.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Fragment01(View view) {
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        Fragment01 fragment01=new Fragment01();
        fragmentTransaction.replace(R.id.fragment,fragment01);
    }

    public void Fragment02(View view) {
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        Fragment02 fragment01=new Fragment02();
        fragmentTransaction.replace(R.id.fragment,fragment01);
    }

}