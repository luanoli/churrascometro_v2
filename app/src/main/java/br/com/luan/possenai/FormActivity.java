package br.com.luan.possenai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Bundle params = getIntent().getExtras();

        if(params != null){
            String nome = params.getString("nome");
            String sobrenome = params.getString("sobrenome");

            TextView nomeFormView = (TextView) findViewById(R.id.nomeFormTextView);
            nomeFormView.setText("Nome: " + nome);

            TextView sobrenomeFormView = (TextView) findViewById(R.id.sobrenomeFormTextView);
            sobrenomeFormView.setText("Sobrenome: " + sobrenome);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
