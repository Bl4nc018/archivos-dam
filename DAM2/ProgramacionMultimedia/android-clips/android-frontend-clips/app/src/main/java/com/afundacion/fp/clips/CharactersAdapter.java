package com.afundacion.fp.clips;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder>{
    private CharactersList charactersToShow;
    public CharactersAdapter(CharactersList charactersList) {
        this.charactersToShow = charactersList;
    }

    // Ejercicio
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1. Necesitamos un LayoutInflater. Lo creamos a partir de un Context
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // 2. Con el LayoutInflater, 'inflamos' el XML y generamos una View
        View characterView = inflater.inflate(R.layout.character_recycler_cell, parent, false);
        // 3. Esta View es la que pasamos al constructor de ClipViewHolder.
        // ¡Y ya está listo!
        CharacterViewHolder characterViewHolder = new CharacterViewHolder(characterView);
        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        // Usamos .get(position) para acceder al 'enésimo' elemento de la lista
        // O sea, el correspondiente a la posición 'position'
        Character dataForThisCell = this.charactersToShow.getCharacters().get(position);
        holder.showData(dataForThisCell);
    }


    @Override
    public int getItemCount() {
        return  this.charactersToShow.getCharacters().size();
    }
}
