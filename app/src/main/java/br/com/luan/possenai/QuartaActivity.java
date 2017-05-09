package br.com.luan.possenai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

import java.io.Serializable;

public class QuartaActivity extends AppCompatActivity {

    Churrasco churrasco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta);

        Intent intent = getIntent();

        if(intent.hasExtra("churrasco")){
            churrasco = (Churrasco) intent.getSerializableExtra("churrasco");
        }

        NumberPicker pessoasNP = (NumberPicker) findViewById(R.id.pessoasNumberPicker);

        pessoasNP.setMinValue(0);
        pessoasNP.setMaxValue(1000);
        pessoasNP.setWrapSelectorWheel(false);
        pessoasNP.setValue(0);
        pessoasNP.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    }

    public void salvarPessoas(View v){
        NumberPicker campoPessoas = (NumberPicker) findViewById(R.id.pessoasNumberPicker);
        churrasco.setPessoas(campoPessoas.getValue());

        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("churrasco", (Serializable) churrasco);

        startActivity(intent);
    }


}
