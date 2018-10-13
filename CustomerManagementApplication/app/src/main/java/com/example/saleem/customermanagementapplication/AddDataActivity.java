package com.example.saleem.customermanagementapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editFirstName, editLastName, editMob, editEMail, editAddress;
    Button btnAddData, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        myDB = new DatabaseHelper(this);

        // Cast test fields
        editFirstName = (EditText)findViewById(R.id.editText_firstname);
        editLastName = (EditText)findViewById(R.id.editText_lastname);
        editMob = (EditText)findViewById(R.id.editText_mobile);
        editEMail = (EditText)findViewById(R.id.editText_email);
        editAddress = (EditText)findViewById(R.id.editText_address);

        // Cast buttons
        btnAddData = (Button)findViewById(R.id.button_addData);
        btnBack = (Button)findViewById(R.id.button_back);

        // Call methods
        addData();
        goBack();
    } // onCreate method ends

    public void addData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(editFirstName.getText().toString(), editLastName.getText().toString(),
                                editMob.getText().toString(), editEMail.getText().toString(), editAddress.getText().toString());
                        if (isInserted)
                            Toast.makeText(AddDataActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddDataActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    } // AddData method ends

    public void goBack() {
        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
