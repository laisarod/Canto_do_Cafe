package com.aula.coffee.Controller;

import org.springframework.context.ApplicationContext;

import java.util.List;


import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.coffee.model.Pedido;
import com.aula.coffee.model.PedidoService;



@Controller
public class MainController {

    @Autowired 
    ApplicationContext ctx;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/formulario")
    public String form(Model model){
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("titulo", "Realize seu pedido");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Pedido ped){
        PedidoService ps = ctx.getBean(PedidoService.class);
        ps.inserirProduto(ped);
        return "redirect:listar";
    }
    

    @GetMapping("/listar")
    public String listar(Model model){
        PedidoService ps = ctx.getBean(PedidoService.class);
        List<Pedido> lista = ps.puxarTodosPedidos();
        model.addAttribute("pedido", lista);
        return "listar";
    }
// Formulário de edição
@GetMapping("/editar")
public String editar(@org.springframework.web.bind.annotation.RequestParam int id, Model model) {
PedidoService ps = ctx.getBean(PedidoService.class);
   Pedido ped = ps.buscarPedidoPorId(id);
   model.addAttribute("pedido", ped);
   model.addAttribute("titulo", "Editar pedido");
   model.addAttribute("link", "/atualizar");
   model.addAttribute("valor", "Atualizar");
   return "formulario";
}

// Atualizar o pedido (POST)
@PostMapping("/atualizar")
public String atualizar(@ModelAttribute Pedido ped) {
   PedidoService ps = ctx.getBean(PedidoService.class);
   ps.atualizarPedido(ped);
   return "redirect:listar";
}

//Remover o pedido
@GetMapping("/remover")
public String remover(@org.springframework.web.bind.annotation.RequestParam int id) {
   PedidoService ps = ctx.getBean(PedidoService.class);
   ps.removerPedido(id);
   return "redirect:listar";
}


}

