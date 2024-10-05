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
import com.example.projectlightsout.databinding.ActivityTresBombillasBinding;

public class TresBombillas extends AppCompatActivity {
    ActivityTresBombillasBinding binding;

    boolean isBomb1On = false;
    boolean isBomb2On = false;
    boolean isBomb3On = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityTresBombillasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        //SET IMAGES
        Drawable bomb_off = ContextCompat.getDrawable(this, R.drawable.apagado);
        Drawable bomb_on = ContextCompat.getDrawable(this, R.drawable.encendido);

        binding.TresBombImg1.setImageDrawable(bomb_off);
        binding.TresBombImg2.setImageDrawable(bomb_off);
        binding.TresBombImg3.setImageDrawable(bomb_off);


        //TOGGLE 1
        binding.TresBombBot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBomb1On) {
                    binding.TresBombImg1.setImageDrawable(bomb_off);
                    isBomb1On = false;
                } else {
                    binding.TresBombImg1.setImageDrawable(bomb_on);
                    isBomb1On = true;
                }
            }
        });

        //TOGGLE 2
        binding.TresBombBot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBomb2On) {
                    binding.TresBombImg2.setImageDrawable(bomb_off);
                    isBomb2On = false;
                } else {
                    binding.TresBombImg2.setImageDrawable(bomb_on);
                    isBomb2On = true;
                }
            }
        });

        //TOGGLE 3
        binding.TresBombBot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBomb3On) {
                    binding.TresBombImg3.setImageDrawable(bomb_off);
                    isBomb3On = false;
                } else {
                    binding.TresBombImg3.setImageDrawable(bomb_on);
                    isBomb3On = true;
                }
            }
        });


        //CHECKBOX1
        binding.TresBombBot1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //CHECKBOX2
        binding.TresBombBot2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //CHECKBOX3
        binding.TresBombBot3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

        //SWITCH
        binding.TresBombSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){ //IS CHECKED
                    binding.TresBombBot1.setEnabled(false);
                    binding.TresBombBot2.setEnabled(false);
                    binding.TresBombBot3.setEnabled(false);
                    binding.TresBombBox1.setEnabled(false);
                    binding.TresBombBox2.setEnabled(false);
                    binding.TresBombBox3.setEnabled(false);
                    binding.TresBombChange.setEnabled(false);
                    Toast.makeText(TresBombillas.this, "Botones desactivados",Toast.LENGTH_SHORT).show();

                }else{
                    binding.TresBombBot1.setEnabled(true);
                    binding.TresBombBot2.setEnabled(true);
                    binding.TresBombBot3.setEnabled(true);
                    binding.TresBombBox1.setEnabled(true);
                    binding.TresBombBox2.setEnabled(true);
                    binding.TresBombBox3.setEnabled(true);
                    binding.TresBombChange.setEnabled(true);
                    Toast.makeText(TresBombillas.this, "Botones activados",Toast.LENGTH_SHORT).show();

                }


            }
        });


        //CHANGE
        binding.TresBombChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.TresBombBox1.isChecked()){
                    if(isBomb1On){
                        binding.TresBombImg1.setImageDrawable(bomb_off);
                        isBomb1On = false;
                    } else {
                        binding.TresBombImg1.setImageDrawable(bomb_on);
                        isBomb1On = true;
                    }
                }
                if(binding.TresBombBox2.isChecked()){
                    if(isBomb2On){
                        binding.TresBombImg2.setImageDrawable(bomb_off);
                        isBomb2On = false;
                    } else {
                        binding.TresBombImg2.setImageDrawable(bomb_on);
                        isBomb2On = true;
                    }
                }
                if(binding.TresBombBox3.isChecked()){
                    if(isBomb3On){
                        binding.TresBombImg3.setImageDrawable(bomb_off);
                        isBomb3On = false;
                    } else {
                        binding.TresBombImg3.setImageDrawable(bomb_on);
                        isBomb3On = true;
                    }
                }
            }
        });




    } //ONCREATE END


}//MAIN END