package com.example.saleem.customermanagementapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDataActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editId, editFirstName, editLastName, editMob, editEMail, editAddress;
    Button btnUpdateData, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        myDB = new DatabaseHelper(this);

        // Cast test fields
        editId = (EditText)findViewById(R.id.editText_id);
        editFirstName = (EditText)findViewById(R.id.editText_firstname);
        editLastName = (EditText)findViewById(R.id.editText_lastname);
        editMob = (EditText)findViewById(R.id.editText_mobile);
        editEMail = (EditText)findViewById(R.id.editText_email);
        editAddress = (EditText)findViewById(R.id.editText_address);

        // Cast buttons
        btnUpdateData = (Button)findViewById(R.id.button_updateData);
        btnBack = (Button)findViewById(R.id.button_back);

        // Call methods
        updateData();
        goBack();
    } // onCreate method ends

    public void updateData() {
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Boolean isUpdated = myDB.updateData(editId.getText().toString(), editFirstName.getText().toString(),
                                editLastName.getText().toString(), editMob.getText().toString(), editEMail.getText().toString(),
                                editAddress.getText().toString());
                        if (isUpdated)
                            Toast.makeText(UpdateDataActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UpdateDataActivity.this, "Data Not Found", Toast.LENGTH_LONG).show();
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
