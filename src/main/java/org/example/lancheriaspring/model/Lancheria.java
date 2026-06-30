package org.example.lancheriaspring.model;

public class Lancheria {

    private int codigo;
    private String endereco;
    private String nome;

    public Lancheria(){}

    public Lancheria(String endereco, String nome){
        this.endereco = endereco;
        this.nome = nome;
    }

    public Lancheria(int codigo, String endereco, String nome){
        this.codigo = codigo;
        this.endereco = endereco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

