package com.example.provamobile;

public class itemAdd {
    private String titulo;
    private String descricao;

    public itemAdd(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String gettitulo() {

        return titulo;
    }

    public String getDescricao() {

        return descricao;
    }
}
