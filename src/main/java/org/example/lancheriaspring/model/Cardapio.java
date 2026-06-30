package org.example.lancheriaspring.model;

public class Cardapio {
    private int codigo;

    private Lanche lanche;
    private Lancheria lancheria;

    private double preco;

    public Cardapio() {
    }

    public Cardapio(
            Lanche lanche,
            Lancheria lancheria,
            double preco) {

        this.lanche = lanche;
        this.lancheria = lancheria;
        this.preco = preco;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public Lancheria getLancheria() {
        return lancheria;
    }

    public void setLancheria(Lancheria lancheria) {
        this.lancheria = lancheria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

