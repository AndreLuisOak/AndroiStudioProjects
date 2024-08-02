package com.example.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    public Fragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        String pessoal_pokemon = "Pessoal";
        SharedPreferences sharedPref = getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String texto = sharedPref.getString(pessoal_pokemon, "default");

        TextView textView = view.findViewById(R.id.tv_pessoal);
        textView.setText(texto);
        return view;
    }
}