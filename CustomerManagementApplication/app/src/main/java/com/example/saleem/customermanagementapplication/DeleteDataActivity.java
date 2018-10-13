package com.example.saleem.customermanagementapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteDataActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editId;
    Button btnDeleteData, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        myDB = new DatabaseHelper(this);

        // Cast test fields
        editId = (EditText)findViewById(R.id.editText_id);

        // Cast buttons
        btnDeleteData = (Button)findViewById(R.id.button_deleteData);
        btnBack = (Button)findViewById(R.id.button_back);

        // Call methods
        deleteData();
        goBack();
    } // onCreate method ends

    public void deleteData() {
        btnDeleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDB.deleteData(editId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(DeleteDataActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DeleteDataActivity.this, "No Record Found", Toast.LENGTH_LONG).show();
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
