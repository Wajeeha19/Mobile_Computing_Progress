package haqnawaz.org.database;

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
import android.widget.Switch;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewCustomer;
    ArrayAdapter<CustomerModel> arrayAdapter;
    DBHelper dbHelper;
    List<CustomerModel> customersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        switchIsActive = findViewById(R.id.switchCustomer);
        listViewCustomer = findViewById(R.id.listViewCustomer);
        RefreshData();
        listViewCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                dbHelper=new DBHelper(MainActivity.this);
                boolean b=dbHelper.deleteCustomer(customersList.get(i));
                RefreshData();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;

            @Override
            public void onClick(View v) {
                try {
                    customerModel = new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked(), 1);
                    //Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                    RefreshData();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                dbHelper=new DBHelper(MainActivity.this);
                boolean b=dbHelper.addCustomer(customerModel);
            }
        });
        
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RefreshData();
            }
        });
    }
    private void RefreshData() {
        dbHelper = new DBHelper(MainActivity.this);
        customersList=dbHelper.getAllRecords();
        //Toast.makeText(MainActivity.this, customersList.toString(), Toast.LENGTH_SHORT).show();
        arrayAdapter=new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1,customersList);
        listViewCustomer.setAdapter(arrayAdapter);

    }
}