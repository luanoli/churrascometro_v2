package br.com.luan.possenai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker carneNP = (NumberPicker) findViewById(R.id.carneNumberPicker);

        carneNP.setMinValue(0);
        carneNP.setMaxValue(3000);
        carneNP.setWrapSelectorWheel(false);
        carneNP.setValue(0);
        carneNP.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        carneNP.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(oldVal < newVal){
                    picker.setValue(oldVal+10);
                }else{
                    picker.setValue(oldVal-10);
                }
            }
        });
    }

    public void salvar(View v){

        Churrasco churrasco = new Churrasco();
        NumberPicker campoCarne = (NumberPicker) findViewById(R.id.carneNumberPicker);
        churrasco.setCarne(campoCarne.getValue());

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("churrasco", (Serializable)churrasco);

        startActivity(intent);


//        EditText campoNome = (EditText) findViewById(R.id.nomeEditText);
//        EditText campoSobrenome = (EditText) findViewById(R.id.sobreNomeEditText);
//
//        String nome = campoNome.getText().toString();
//        String sobrenome = campoSobrenome.getText().toString();
//
//        Intent intent = new Intent(this, FormActivity.class);
//        intent.putExtra("nome", nome);
//        intent.putExtra("sobrenome", sobrenome);
//
//        startActivity(intent);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if(id == R.id.action_settings){
//            Toast.makeText(this, "Configurações", Toast.LENGTH_LONG).show();
//            return true;
//        }
//
//        if(id == R.id.action_others){
//            Toast.makeText(this, "Others", Toast.LENGTH_LONG).show();
//            return true;
//        }
//
//        if(id == R.id.menu_categories){
//            Intent intent = new Intent(this, CategoriesActivity.class);
//
//            intent.putExtra("mensagem", "teste bundle");
//
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


}
