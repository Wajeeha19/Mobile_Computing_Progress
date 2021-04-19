package org.haqnawaz.dialog_20210412;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;

    ArrayList<Integer> selectedItems= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnDialog);
    }

    public void ShowDialog(View view) {
        String[] colors = {"Red", "Blue", "Green"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Dialog Title");

        /*builder.setItems(colors, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Toast.makeText(MainActivity.this,colors[which],Toast.LENGTH_LONG);
              }
          });*/
        /*builder.setMessage("It is message of my Dialog");*/
        builder.setMultiChoiceItems(colors, null, (dialog, which, isChecked) -> {
            if (isChecked) {
                selectedItems.add(which);
            } else {
                if (selectedItems.contains(which)) {
                    selectedItems.remove(Integer.valueOf(which));
                }
            }
        });
        builder.setCancelable(false);
        builder.setPositiveButton("Positive",
                (dialogInterface, i) -> {
                    StringBuilder msg = new StringBuilder();
                    for (int j = 0; j < selectedItems.size(); j++) {
                        msg.append("\n").append(j + 1).append(" : ").append(colors[selectedItems.get(j)]);
                    }
                    Toast.makeText(getApplicationContext(), "Total " + selectedItems.size()
                            + " Items Selected.\n" + msg, Toast.LENGTH_SHORT).show();
                    finish();
                }
        ).setNegativeButton("Negative",
                (dialogInterface, i) -> {
                    Toast.makeText(MainActivity.this, "No Items Selected", Toast.LENGTH_LONG).show();
                    dialogInterface.cancel();
                }

        );

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}