package com.example.projectlightsout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectlightsout.databinding.ActivityDosBombillasBinding;


public class DosBombillas extends AppCompatActivity {
    ActivityDosBombillasBinding binding;

    boolean isBomb1On = false;
    boolean isBomb2On = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDosBombillasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();




        //SET IMAGES
        Drawable bomb_off = ContextCompat.getDrawable(this, R.drawable.apagado);
        Drawable bomb_on = ContextCompat.getDrawable(this, R.drawable.encendido);

        binding.DosBombImg1.setImageDrawable(bomb_off);
        binding.DosBombImg2.setImageDrawable(bomb_off);

        // TOGGLE 1
        binding.DosBombBot1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    binding.DosBombImg1.setImageDrawable(bomb_on);
                    isBomb1On = true;
                } else {
                    binding.DosBombImg1.setImageDrawable(bomb_off);
                    isBomb1On = false;
                }
            }
        });

// TOGGLE 2
        binding.DosBombBot2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    binding.DosBombImg2.setImageDrawable(bomb_on);
                    isBomb2On = true;
                } else {
                    binding.DosBombImg2.setImageDrawable(bomb_off);
                    isBomb2On = false;
                }
            }
        });



        //CHECKBOX1
        binding.DosBombBot1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //CHECKBOX1
        binding.DosBombBot2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //SWITCH
        binding.DosBombSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){ //IS CHECKED
                    binding.DosBombBot1.setEnabled(false);
                    binding.DosBombBot2.setEnabled(false);
                    binding.DosBombBox1.setEnabled(false);
                    binding.DosBombBox2.setEnabled(false);
                    binding.DosBombChange.setEnabled(false);
                    Toast.makeText(DosBombillas.this, "Botones desactivados",Toast.LENGTH_SHORT).show();

                }else{
                    binding.DosBombBot1.setEnabled(true);
                    binding.DosBombBot2.setEnabled(true);
                    binding.DosBombBox1.setEnabled(true);
                    binding.DosBombBox2.setEnabled(true);
                    binding.DosBombChange.setEnabled(true);
                    Toast.makeText(DosBombillas.this, "Botones activados",Toast.LENGTH_SHORT).show();

                }


            }
        });

        //CHANGE
        binding.DosBombChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.DosBombBox1.isChecked()){
                    if(isBomb1On){
                        binding.DosBombImg1.setImageDrawable(bomb_off);
                        isBomb1On = false;
                    } else {
                        binding.DosBombImg1.setImageDrawable(bomb_on);
                        isBomb1On = true;
                    }
                }
                if(binding.DosBombBox2.isChecked()){
                    if(isBomb2On){
                        binding.DosBombImg2.setImageDrawable(bomb_off);
                        isBomb2On = false;
                    } else {
                        binding.DosBombImg2.setImageDrawable(bomb_on);
                        isBomb2On = true;
                    }
                }
            }
        });


    }//ONCREATE END

}//MAIN END