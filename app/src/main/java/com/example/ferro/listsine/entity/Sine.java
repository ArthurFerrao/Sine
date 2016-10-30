package com.example.ferro.listsine.entity;

/**
 * Created by Ferrão on 29/10/2016.
 */
public class Sine {
    private String codPosto;
    private String nome;
    private String entidadeConveniada;
    private String uf;

    public Sine(String codPosto, String nome, String entidadeConveniada, String uf) {
        this.codPosto = codPosto;
        this.nome = nome;
        this.entidadeConveniada = entidadeConveniada;
        this.uf = uf;
    }

    public String getCodPosto() {return codPosto;}

    public void setCodPosto(String codPosto) {this.codPosto = codPosto;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}
    public String getUf() {return uf;}

    public void setUf(String uf) {this.uf = uf;}

    public String getEntidadeConveniada() {return entidadeConveniada;}

    public void setEntidadeConveniada(String entidadeConveniada) {this.entidadeConveniada = entidadeConveniada;}

    @Override
    public String toString(){
        return(
                "Código do posto: " + getCodPosto() + "\n" +
                        "Nome: " + getNome() + "\n" +
                        "Entidade Conveniada: " + getEntidadeConveniada() + "\n" +
                        "Estado: " + getUf() + "\n");
    }
}
