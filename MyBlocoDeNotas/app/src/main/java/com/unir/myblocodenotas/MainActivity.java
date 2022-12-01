package com.unir.myblocodenotas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.unir.myblocodenotas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Anotacao anotacao;
    private EditText edit_anotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anotacao = new Anotacao(MainActivity.this);
        edit_anotacao = findViewById(R.id.edtAnotacao);
        FloatingActionButton fab = findViewById(R.id.fab);

        String texto = anotacao.getAnotacao();
        if (!texto.isEmpty()){
            edit_anotacao.setText(texto);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = edit_anotacao.getText().toString();
                if (texto.isEmpty()){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else {
                    anotacao.salvarAnotacao(texto);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Desfazer", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    anotacao.limparAnotacao();
                                }
                            })
                            .show();
                }
            }
        });



    }


}