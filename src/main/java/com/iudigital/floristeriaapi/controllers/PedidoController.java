package com.iudigital.floristeriaapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.floristeriaapi.models.PedidoModel;
import com.iudigital.floristeriaapi.services.PedidosService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController{
    
    @Autowired
    private final PedidosService pedidosService = null;

    // public PedidoController (PedidosService pedidosService){
    //     this.pedidosService=pedidosService;
    // }
    
    @GetMapping("/pedidosinventario")
    public String showPedidos (Model model){
    try {
        List <PedidoModel> pedidos= pedidosService.getAllPedidos();
        model.addAttribute("pedidosParaInventario",pedidos);
        return "/pedidosinventario";
    } catch (Exception e){
            return "error";
        }
    }

@GetMapping("/")
public String inicio(){
    return "index";
}

    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    

    @PostMapping("/guardarpedido")
    public String savePedido (@ModelAttribute PedidoModel pedido){
        this.pedidosService.savePedido(pedido);
        return "redirect/totalpedido";
    }

    @GetMapping("/eliminarPedido/{id_pedido}")
    public String deletePedido(@PathVariable("id_pedido") Long id_pedido){
        pedidosService.deletePedido(id_pedido);
        return "redirect:/inventario";
    }
    

    @GetMapping(path ="/{id}")
    public Optional <PedidoModel> getPedidoById (@PathVariable("id") long id){
        return this.pedidosService.getPedidoById(id);
    }

    @PutMapping(path = "/{id}")
    public PedidoModel updateById (@RequestBody PedidoModel pedido, @PathVariable("id") Long id){
        return this.pedidosService.updateById(pedido, id);
    }

    @GetMapping({"/Pedidos","/"})
    public String crearPedido() {
        return "crear-pedido";
    }

    public PedidosService getPedidosService() {
        return pedidosService;
    }

    public PedidoController() {
    }

    @Override
    public String toString() {
        return "PedidoController [pedidosService=" + pedidosService + "]";
    }
  }

    // @DeleteMapping (path ="/eliminarpedido/{id}")
    // public String deletePedido (@PathVariable ("id")Long id){
    //     boolean ok = this.pedidosService.deletePedido(id);
    //     if (ok) return "redirect/totalpedidos";
    //     else return "error";
    // }

    // @GetMapping({"/pedido","/"})
    // public String crearPedido() {
    //     return "crear-pedido";
    // }
    // @GetMapping("/arreglos")
    // public String mostrarArreglos() {
    //     return "arreglos";  
    // }

    // @GetMapping("/entregas")
    // public String mostrarEntregas() {
    //     return "entregas";  
    // }

    // @GetMapping("/finanzas")
    // public String mostrarFinanzas() {
    //     return "finanzas";  
    // }

    // @GetMapping("/informes")
    // public String mostrarInformes() {
    //     return "informes";  
    // }
  






