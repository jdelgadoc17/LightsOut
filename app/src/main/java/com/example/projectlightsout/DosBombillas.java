package com.example.projectlightsout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

    static final String BOMB1_STATE ="Estado de bombilla 1";
    static final String BOMB2_STATE ="Estado de bombilla 2";
    static final String BOT1_STATE ="Estado de boton 1";
    static final String BOT2_STATE ="Estado de boton 2";
    static final String CHECK1_STATE ="Estado de check 1";
    static final String CHECK2_STATE ="Estado de check 2";
    static final String LOCK_STATE ="Estado de bloqueo";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDosBombillasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        //RECOVER STATE
        if(savedInstanceState!=null){
            isBomb1On = savedInstanceState.getBoolean(BOMB1_STATE);
            isBomb2On = savedInstanceState.getBoolean(BOMB2_STATE);

            if (isBomb1On) {
                binding.DosBombImg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.encendido));
            } else {
                binding.DosBombImg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apagado));
            }

            if (isBomb2On) {
                binding.DosBombImg2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.encendido));
            } else {
                binding.DosBombImg2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apagado));
            }

            binding.DosBombBox1.setChecked(savedInstanceState.getBoolean(CHECK1_STATE, false));
            binding.DosBombBox2.setChecked(savedInstanceState.getBoolean(CHECK2_STATE, false));

            boolean checkeado = savedInstanceState.getBoolean(LOCK_STATE, false);
            binding.DosBombSwitch.setChecked(checkeado);

            binding.DosBombBot1.setEnabled(!checkeado);
            binding.DosBombBot2.setEnabled(!checkeado);
            binding.DosBombBox1.setEnabled(!checkeado);
            binding.DosBombBox2.setEnabled(!checkeado);
            binding.DosBombChange.setEnabled(!checkeado);
        }


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
                    Toast.makeText(DosBombillas.this, R.string.bot_activados,Toast.LENGTH_SHORT).show();

                }else{
                    binding.DosBombBot1.setEnabled(true);
                    binding.DosBombBot2.setEnabled(true);
                    binding.DosBombBox1.setEnabled(true);
                    binding.DosBombBox2.setEnabled(true);
                    binding.DosBombChange.setEnabled(true);
                    Toast.makeText(DosBombillas.this, R.string.bot_desactivados,Toast.LENGTH_SHORT).show();

                }


            }
        });

        //CHANGE
        binding.DosBombChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.DosBombBox1.isChecked()) {
                    if (isBomb1On) {
                        isBomb1On = false;
                        binding.DosBombImg1.setImageDrawable(bomb_off);
                        binding.DosBombBot1.setText(R.string.apagado);
                    } else {
                        isBomb1On = true;
                        binding.DosBombImg1.setImageDrawable(bomb_on);
                        binding.DosBombBot1.setText(R.string.encendido);
                    }
                }

                if (binding.DosBombBox2.isChecked()) {
                    if (isBomb2On) {
                        isBomb2On = false;
                        binding.DosBombImg2.setImageDrawable(bomb_off);
                        binding.DosBombBot2.setText(R.string.apagado);
                    } else {
                        isBomb2On = true;
                        binding.DosBombImg2.setImageDrawable(bomb_on);
                        binding.DosBombBot2.setText(R.string.encendido);
                    }
                }
            }
        });



    }//ONCREATE END

}//MAIN END