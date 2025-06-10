package com.aula.coffee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pedido {
    private int id;
    private String nome;
    private String produto;
    private int quantidade;
    private String obs;


    public Pedido(){

    }

    //cadastrar
    public Pedido(String nome, String produto, int quantidade, String obs){
        this.nome = nome;
        this.produto = produto;
        this.quantidade = quantidade;
        this.obs = obs;

    }

    //criar 
      public Pedido(int id, String nome, String produto, int quantidade, String obs){
        this.id = id;
        this.nome = nome;
        this.produto = produto;
        this.quantidade = quantidade;
        this.obs = obs;

    }

      public int getId() {
          return id;
      }

      public void setId(int id) {
          this.id = id;
      }

      public String getNome() {
          return nome;
      }

      public void setNome(String nome) {
          this.nome = nome;
      }

      public String getProduto() {
          return produto;
      }

      public void setProduto(String produto) {
          this.produto = produto;
      }

      public int getQuantidade() {
          return quantidade;
      }

      public void setQuantidade(int quantidade) {
          this.quantidade = quantidade;
      }

      public String getObs() {
          return obs;
      }

      public void setObs(String obs) {
          this.obs = obs;
      }

      public static Pedido converter(Map<String, Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String produto = (String) registro.get("produto");
        int quantidade = (int) registro.get("quantidade");
        String obs = (String) registro.get("obs");
        return new Pedido(id, nome, produto, quantidade, obs);
        
      }

   public static List<Pedido> converterVarios(List<Map<String, Object>> registros) {
    List<Pedido> lista = new ArrayList<Pedido>();
    for (Map<String, Object> reg : registros) {
        lista.add(converter(reg));
    }
    return lista;
}

    

}



