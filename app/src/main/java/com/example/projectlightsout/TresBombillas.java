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

import com.example.projectlightsout.databinding.ActivityTresBombillasBinding;

public class TresBombillas extends AppCompatActivity {
    ActivityTresBombillasBinding binding;

    boolean isBomb1On = false;
    boolean isBomb2On = false;
    boolean isBomb3On = false;

    static final String BOMB1_STATE ="Estado de bombilla 1";
    static final String BOMB2_STATE ="Estado de bombilla 2";
    static final String BOMB3_STATE ="Estado de bombilla 3";
    static final String BOT1_STATE ="Estado de boton 1";
    static final String BOT2_STATE ="Estado de boton 2";
    static final String BOT3_STATE ="Estado de boton 3";

    static final String CHECK1_STATE ="Estado de check 1";
    static final String CHECK2_STATE ="Estado de check 2";
    static final String CHECK3_STATE ="Estado de check 3";
    static final String LOCK_STATE ="Estado de bloqueo";


    //SAVE STATE
    @Override
    public void onSaveInstanceState( Bundle savedInstanceState) {
        savedInstanceState.putBoolean(BOMB1_STATE, isBomb1On);
        savedInstanceState.putBoolean(BOMB2_STATE, isBomb2On);
        savedInstanceState.putBoolean(BOMB3_STATE, isBomb3On);
        savedInstanceState.putBoolean(BOT1_STATE, binding.TresBombBot1.isChecked());
        savedInstanceState.putBoolean(BOT2_STATE, binding.TresBombBot2.isChecked());
        savedInstanceState.putBoolean(BOT3_STATE, binding.TresBombBot3.isChecked());
        savedInstanceState.putBoolean(CHECK1_STATE, binding.TresBombBox1.isChecked());
        savedInstanceState.putBoolean(CHECK2_STATE, binding.TresBombBox2.isChecked());
        savedInstanceState.putBoolean(CHECK2_STATE, binding.TresBombBox3.isChecked());
        savedInstanceState.putBoolean(LOCK_STATE, binding.TresBombSwitch.isChecked());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityTresBombillasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //RECOVER STATE

        if(savedInstanceState!=null){
            isBomb1On = savedInstanceState.getBoolean(BOMB1_STATE, false);
            isBomb2On = savedInstanceState.getBoolean(BOMB2_STATE, false);
            isBomb3On = savedInstanceState.getBoolean(BOMB3_STATE, false);

            if(isBomb1On){
                binding.TresBombImg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.encendido));

            }else{
                binding.TresBombImg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apagado));
            }

            if(isBomb2On){
                binding.TresBombImg2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.encendido));

            }else{
                binding.TresBombImg2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apagado));
            }

            if(isBomb3On){
                binding.TresBombImg3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.encendido));

            }else{
                binding.TresBombImg3.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apagado));
            }

            binding.TresBombBox1.setChecked(savedInstanceState.getBoolean(CHECK1_STATE, false));
            binding.TresBombBox2.setChecked(savedInstanceState.getBoolean(CHECK2_STATE, false));
            binding.TresBombBox3.setChecked(savedInstanceState.getBoolean(CHECK3_STATE, false));

            boolean chequeado = savedInstanceState.getBoolean(LOCK_STATE, false);
            binding.TresBombSwitch.setChecked(chequeado);

            binding.TresBombBot1.setEnabled(!chequeado);
            binding.TresBombBot2.setEnabled(!chequeado);
            binding.TresBombBot3.setEnabled(!chequeado);

            binding.TresBombBox1.setEnabled(!chequeado);
            binding.TresBombBox2.setEnabled(!chequeado);
            binding.TresBombBox3.setEnabled(!chequeado);
            binding.TresBombChange.setEnabled(!chequeado);

        }






        //SET IMAGES
        Drawable bomb_off = ContextCompat.getDrawable(this, R.drawable.apagado);
        Drawable bomb_on = ContextCompat.getDrawable(this, R.drawable.encendido);

        binding.TresBombImg1.setImageDrawable(bomb_off);
        binding.TresBombImg2.setImageDrawable(bomb_off);
        binding.TresBombImg3.setImageDrawable(bomb_off);

        // TOGGLE 1
        binding.TresBombBot1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    binding.TresBombImg1.setImageDrawable(bomb_on);
                    isBomb1On = true;
                } else {
                    binding.TresBombImg1.setImageDrawable(bomb_off);
                    isBomb1On = false;
                }
            }
        });

        // TOGGLE 2
        binding.TresBombBot2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    binding.TresBombImg2.setImageDrawable(bomb_on);
                    isBomb2On = true;
                } else {
                    binding.TresBombImg2.setImageDrawable(bomb_off);
                    isBomb2On = false;
                }
            }
        });

        // TOGGLE 3
        binding.TresBombBot3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    binding.TresBombImg3.setImageDrawable(bomb_on);
                    isBomb3On = true;
                } else {
                    binding.TresBombImg3.setImageDrawable(bomb_off);
                    isBomb3On = false;
                }
            }
        });

        //SWITCH para desactivar botones
        binding.TresBombSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) { // Desactivar todos los botones
                    binding.TresBombBot1.setEnabled(false);
                    binding.TresBombBot2.setEnabled(false);
                    binding.TresBombBot3.setEnabled(false);
                    binding.TresBombBox1.setEnabled(false);
                    binding.TresBombBox2.setEnabled(false);
                    binding.TresBombBox3.setEnabled(false);
                    binding.TresBombChange.setEnabled(false);
                    Toast.makeText(TresBombillas.this, R.string.bot_activados, Toast.LENGTH_SHORT).show();
                } else { // Activar todos los botones
                    binding.TresBombBot1.setEnabled(true);
                    binding.TresBombBot2.setEnabled(true);
                    binding.TresBombBot3.setEnabled(true);
                    binding.TresBombBox1.setEnabled(true);
                    binding.TresBombBox2.setEnabled(true);
                    binding.TresBombBox3.setEnabled(true);
                    binding.TresBombChange.setEnabled(true);
                    Toast.makeText(TresBombillas.this, R.string.bot_desactivados, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //CHANGE para cambiar bombillas según checkbox
        binding.TresBombChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.TresBombBox1.isChecked()) {
                    if (isBomb1On) {
                        binding.TresBombImg1.setImageDrawable(bomb_off);
                        isBomb1On = false;
                    } else {
                        binding.TresBombImg1.setImageDrawable(bomb_on);
                        isBomb1On = true;
                    }
                }
                if (binding.TresBombBox2.isChecked()) {
                    if (isBomb2On) {
                        binding.TresBombImg2.setImageDrawable(bomb_off);
                        isBomb2On = false;
                    } else {
                        binding.TresBombImg2.setImageDrawable(bomb_on);
                        isBomb2On = true;
                    }
                }
                if (binding.TresBombBox3.isChecked()) {
                    if (isBomb3On) {
                        binding.TresBombImg3.setImageDrawable(bomb_off);
                        isBomb3On = false;
                    } else {
                        binding.TresBombImg3.setImageDrawable(bomb_on);
                        isBomb3On = true;
                    }
                }
            }
        });


    }//ONCREATE END


}//MAIN END
