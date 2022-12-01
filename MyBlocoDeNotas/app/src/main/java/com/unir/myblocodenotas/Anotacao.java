package com.unir.myblocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {
    private Context context;
    private SharedPreferences preferences;
    private  final String NOME_ARQUIVO = "anotacoes";
    private final String CHAVE_ARQUIVO = "nome";
    private SharedPreferences.Editor editor;

    public Anotacao(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_ARQUIVO, anotacao);
        editor.commit();

    }

    public String getAnotacao(){
        String anotacao = preferences.getString(CHAVE_ARQUIVO, "");
        return anotacao;
    }

    public void limparAnotacao(){
        editor.clear();
        editor.commit();
    }

}
