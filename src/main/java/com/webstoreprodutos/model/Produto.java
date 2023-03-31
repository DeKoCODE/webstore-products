package com.webstoreprodutos.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tab_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String grupo;
    private String item;
    private Integer memoria;
    private Integer armazenamento;
    private String fabricante;

    public Produto() {
    }

    public Produto(String grupo, String item, Integer memoria, Integer armazenamento, String fabricante) {
        this.grupo = grupo;
        this.item = item;
        this.memoria = memoria;
        this.armazenamento = armazenamento;
        this.fabricante = fabricante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getMemoria() {
        return memoria;
    }

    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public Integer getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(Integer armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
