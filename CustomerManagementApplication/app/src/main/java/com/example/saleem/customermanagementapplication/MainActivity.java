package com.example.saleem.customermanagementapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button btnAddData, btnViewAllData, btnUpdateData, btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        // Cast buttons
        btnAddData = (Button)findViewById(R.id.button_addData);
        btnViewAllData = (Button)findViewById(R.id.button_viewAllData);
        btnUpdateData = (Button)findViewById(R.id.button_updateData);
        btnDeleteData = (Button)findViewById(R.id.button_deleteData);

        // Call methods
        AddData();
        viewAllData();
        updateData();
        deleteData();
    } // onCreate method ends

    // Add Data button will take user to new activity
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AddDataActivity.class);
                        startActivity(intent);
                    }
                }
        );
    } // AddData method ends

    // Delete Data button will take user to new activity
    public void deleteData() {
        btnDeleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), DeleteDataActivity.class);
                        startActivity(intent);
                    }
                }
        );
    } // deleteData method ends

    // Update Data button will take user to new activity
    public void updateData() {
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), UpdateDataActivity.class);
                        startActivity(intent);
                    }
                }
        );
    } // updateData method ends

    public void viewAllData() {
        btnViewAllData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor result = myDB.getAllData();
                        if (result.getCount() == 0) {

                            // show message
                            showMessage("Error", "No Data Found");
                            return;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        while (result.moveToNext()) {
                            stringBuffer.append("Id : " + result.getString(0) + "\n");
                            stringBuffer.append("First Name : " + result.getString(1) + "\n");
                            stringBuffer.append("Last Name : " + result.getString(2) + "\n");
                            stringBuffer.append("Mobile : " + result.getString(3) + "\n");
                            stringBuffer.append("Email : " + result.getString(4) + "\n");
                            stringBuffer.append("Address : " + result.getString(5) + "\n\n");
                        }

                        // show all data
                        showMessage("Data", stringBuffer.toString());
                    }
                }
        );
    } // viewAllData method ends

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    } // showMessage method ends


}
