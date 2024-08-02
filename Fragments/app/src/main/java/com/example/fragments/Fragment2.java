package com.example.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    public Fragment2(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        String profissional_pokemon = "Profissional";
        SharedPreferences sharedPref =  getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String texto = sharedPref.getString(profissional_pokemon, "default");

        TextView textView = view.findViewById(R.id.tv_Profissional);
        textView.setText(texto);

        return view;
    }

}