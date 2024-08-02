package br.ufc.quixada.usoroomdatabase;

public class itemAdd {
    private String nome;
    private String curso;
    private int idade;

    public itemAdd(String nome, String curso, int idade){
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getIdade() {
        return idade;
    }
}