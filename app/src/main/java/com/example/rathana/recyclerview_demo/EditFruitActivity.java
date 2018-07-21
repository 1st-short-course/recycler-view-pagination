package com.example.rathana.recyclerview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditFruitActivity extends AppCompatActivity {

    private EditText title;
    private Button btnSaveChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_fruit);

        title=findViewById(R.id.title);
        btnSaveChange=findViewById(R.id.btnSaveChange);
        btnSaveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.putExtra("pos",getIntent().getIntExtra("pos",0));
                intent.putExtra("title",title.getText().toString());
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}
