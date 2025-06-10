package com.aula.coffee.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    PedidoDao pdao;

    public void inserirProduto(Pedido ped){
        pdao.inserirProduto(ped);
    }

    public List<Pedido> puxarTodosPedidos(){
    return Pedido.converterVarios(pdao.puxarTodosPedidos());
}

}
