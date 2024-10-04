package com.example.projectlightsout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectlightsout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        //SPINNER
        String[] spinner_valores ={"", "2", "3"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinner_valores);
        binding.MainSpinner.setAdapter(adaptador);

        binding.MainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(adapterView.getAdapter().getItem(i)!=""){
                    Toast.makeText(MainActivity.this, "Opción elegida", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DosBombillas.class);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); //SPINNER END



    }//ONCREATE END


}//MAIN END