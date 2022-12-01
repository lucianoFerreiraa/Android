package com.unir.recyclerview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Exemplo extends RecyclerView.Adapter<Exemplo.Teste>{


    @NonNull
    @Override
    public Teste onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Teste holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Teste extends RecyclerView.ViewHolder {

        public Teste(@NonNull View itemView) {
            super(itemView);
        }
    }
}
