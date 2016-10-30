package com.example.ferro.listsine.entity;

/**
 * Created by Ferrão on 29/10/2016.
 */
public class Sine {
    private String codPosto;
    private String nome;
    private String entidadeConveniada;
    private String endereco;
    private String bairro;
    private String cep;
    private String telefone;
    private String municipio;
    private String uf;
    private String lat;
    private String lon;

    public Sine(String codPosto, String nome, String entidadeConveniada, String endereco, String bairro, String cep, String telefone, String municipio, String uf, String lat, String lon) {
        this.codPosto = codPosto;
        this.nome = nome;
        this.entidadeConveniada = entidadeConveniada;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.municipio = municipio;
        this.uf = uf;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCodPosto() {return codPosto;}

    public void setCodPosto(String codPosto) {this.codPosto = codPosto;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCep() {return cep;}

    public void setCep(String cep) {this.cep = cep;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getMunicipio() {return municipio;}

    public void setMunicipio(String municipio) {this.municipio = municipio;}

    public String getUf() {return uf;}

    public void setUf(String uf) {this.uf = uf;}

    public String getLat() {return lat;}

    public void setLat(String lat) {this.lat = lat;}

    public String getLon() {return lon;}

    public void setLon(String lon) {this.lon = lon;}

    public String getEntidadeConveniada() {return entidadeConveniada;}

    public void setEntidadeConveniada(String entidadeConveniada) {this.entidadeConveniada = entidadeConveniada;}

    @Override
    public String toString(){
        return(
                "Código do posto: " + getCodPosto() + "\n" +
                        "Nome: " + getNome() + "\n" +
                        "Entidade Conveniada: " + getEntidadeConveniada() + "\n" +
                        "Endereço: " + getEndereco() + "\n" +
                        "Bairro: " + getBairro() + "\n" +
                        "CEP: " + getCep() + "\n" +
                        "Telefone: " + getTelefone() + "\n" +
                        "Múnicipio: " + getMunicipio() + "\n" +
                        "Estado: " + getUf() + "\n" +
                        "Latitude: " + getLat() + "\n" +
                        "Longitude: " + getLon() + "\n");
    }
}
