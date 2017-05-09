package br.com.luan.possenai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class SegundaActivity extends AppCompatActivity {

    Churrasco churrasco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();

        if(intent.hasExtra("churrasco")){
            churrasco = (Churrasco) intent.getSerializableExtra("churrasco");
        }

        NumberPicker linguicaNP = (NumberPicker) findViewById(R.id.linguicaNumberPicker);

        linguicaNP.setMinValue(0);
        linguicaNP.setMaxValue(50);
        linguicaNP.setWrapSelectorWheel(false);
        linguicaNP.setValue(0);
        linguicaNP.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

    }

    public void salvarLinguica(View v) {

        NumberPicker campoLinguica = (NumberPicker) findViewById(R.id.linguicaNumberPicker);
        churrasco.setLinguica(campoLinguica.getValue());

        Intent intent = new Intent(this, TerceiraActivity.class);
        intent.putExtra("churrasco", (Serializable) churrasco);

        startActivity(intent);
    }


}
