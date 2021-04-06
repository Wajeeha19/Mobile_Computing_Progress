package org.haqnawaz.mc05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText text;
    ArrayList<String> friendList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        friendList = new ArrayList<String>();
        friendList.add("Wajeeha");
        friendList.add("Hamza");
        friendList.add("Saim");
        friendList.add("Nadia");
        friendList.add("Bushra");
        friendList.add("Nadia");
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        text = findViewById(R.id.textInputEditText2);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Friend Name", friendList.get(i));
                startActivity(intent);
            }
        });
    }

    public void AddFriend(View view) {
        friendList.add(text.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        Collections.sort(friendList);
    }
}