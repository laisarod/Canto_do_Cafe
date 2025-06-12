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
    // Atualizar pedido
    //public void atualizarPedido(Pedido ped) {
    //pdao.atualizarPedido(ped);
//}

//Remover pedido
 //public void removerPedido(int id) {
// pdao.removerPedido(id);
//}
// Buscar um pedido por ID
//public Pedido buscarPedidoPorId(int id) {
   // return Pedido.converter(pdao.puxarPedido(id));
//}

   // public List<Pedido> puxarTodosPedidos(){
    //return Pedido.converterVarios(pdao.puxarTodosPedidos());
//}

}
