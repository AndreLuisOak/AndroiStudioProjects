package com.example.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    public Fragment3(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        String detalhes_pokemon = "Detalhes";
        SharedPreferences sharedPref = getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String texto = sharedPref.getString(detalhes_pokemon, "default");

        TextView textView = view.findViewById(R.id.tv_detalhes);
        textView.setText(texto);

        return view;
    }

}