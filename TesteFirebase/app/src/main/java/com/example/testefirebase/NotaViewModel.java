package com.example.testefirebase;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class NotaViewModel extends BaseObservable {
    private Nota nota;

    public NotaViewModel(){
        nota = new Nota("Meu", "nome");
    }
    @Bindable
    public String getNotaTitulo(){
        return nota.getTitulo();
    }
    @Bindable
    public String getNotaDescricao(){
        return nota.descricao;
    }
    public Nota getNota(){
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
        notifyPropertyChanged(BR.notaTitulo);
        notifyPropertyChanged(BR.notaDescricao);
    }
    public void setNotaDEtails(String titulo, String descricao){
        this.nota.setTitulo(titulo);
        this.nota.setDescricao(descricao);
        notifyPropertyChanged(BR.notaTitulo);
        notifyPropertyChanged(BR.notaDescricao);
    }
    public void validateTextField(){
        // do something...
    }
}
