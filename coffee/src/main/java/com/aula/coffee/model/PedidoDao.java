package com.aula.coffee.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PedidoDao {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirProduto(Pedido ped){
        String sql = "INSERT INTO pedido(nome, produto, quantidade, obs) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4];
        parametros[0] = ped.getNome();
        parametros[1] = ped.getProduto();
        parametros[2] = ped.getQuantidade();
        parametros[3] = ped.getObs();
        jdbc.update(sql, parametros);

    }

    
      public List<Map<String, Object>>puxarTodosPedidos(){
        String sql = "SELECT * FROM pedido";
        return jdbc.queryForList(sql);
    }

    public Map<String, Object> puxarPedido(int id){
        String sql = "SELECT * from pedido WHERE id =? ";
        return jdbc.queryForMap(sql,id);

    }
}
