package com.example.dz4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnOpenFragment;
    EditText etValue;
    boolean temp = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenFragment = findViewById(R.id.btn_open_fragment);
        etValue =  findViewById(R.id.et_value);
        btnOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etValue.getText().toString();
                if (text != null){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    if (temp){
                        transaction.replace(R.id.container_fragment, FirstFragment.newInstance(text, "Text 2"));
                        transaction.addToBackStack("First Fragment");
                        temp=false;
                    }else {
                        transaction.replace(R.id.container_fragment, SecondFragment.newInstance(text, "Text 2"));
                        transaction.addToBackStack("Second Fragment");
                        temp = true;
                    }
                    transaction.commit();
                }else{
                    etValue.setError("Please enter text");
                }
            }
        });
    }
}