package com.unir.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> itens = new ArrayList<String>(Arrays.asList(
       "Tancredo neves", "Três Marias", "JK",
       "São Francisco", "Jardim santana", "Ulisses Guimarães",
       "Mariana", "Pantanal", "Escola de Policia",
       "Planalto", "Teixeirão", "Tiradentes",
            "Lagoa", "Marcos Freire", "Socialista", "Cristal da calama",
            "Cidede do lobo", "Gurgel", "TN"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        //Criar adaptador para lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens);
        //adicionar adaptador para a lista
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override // int i é o id do array e o long l é o id do componente
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelecionado = listView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                itens.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}