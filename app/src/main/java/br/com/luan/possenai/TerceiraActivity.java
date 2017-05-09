package br.com.luan.possenai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

import java.io.Serializable;

public class TerceiraActivity extends AppCompatActivity {

    Churrasco churrasco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        Intent intent = getIntent();

        if(intent.hasExtra("churrasco")){
            churrasco = (Churrasco) intent.getSerializableExtra("churrasco");
        }

        NumberPicker refrigeranteNP = (NumberPicker) findViewById(R.id.refrigeranteNumberPicker);


        refrigeranteNP.setMinValue(0);
        refrigeranteNP.setMaxValue(3000);
        refrigeranteNP.setWrapSelectorWheel(false);
        refrigeranteNP.setValue(0);
        refrigeranteNP.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        refrigeranteNP.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (oldVal < newVal) {
                    picker.setValue(oldVal + 10);
                } else {
                    picker.setValue(oldVal - 10);
                }
            }
        });
    }

    public void salvarRefrigerante(View v){
        NumberPicker campoRefrigerante = (NumberPicker) findViewById(R.id.refrigeranteNumberPicker);
        churrasco.setRefrigerante(campoRefrigerante.getValue());

        Intent intent = new Intent(this, QuartaActivity.class);
        intent.putExtra("churrasco", (Serializable) churrasco);

        startActivity(intent);
    }


}
