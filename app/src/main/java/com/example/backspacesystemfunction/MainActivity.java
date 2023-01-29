package com.example.backspacesystemfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtInput;
    Button btnClearOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edt_input);
        btnClearOne = findViewById(R.id.btn_clear_one);

        btnClearOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtInput, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        });
    }
}