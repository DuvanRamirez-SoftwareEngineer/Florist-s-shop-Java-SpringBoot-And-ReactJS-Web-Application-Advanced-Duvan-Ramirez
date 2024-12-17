package com.iudigital.floristeriaapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.floristeriaapi.models.PedidoModel;
import com.iudigital.floristeriaapi.repositories.IPedidoRepository;

@Service
public class PedidosService {

  @Autowired
  private final IPedidoRepository pedidoRepository;

  public PedidosService(IPedidoRepository pedidosRepository) {
    this.pedidoRepository = pedidosRepository;
  }

  public List<PedidoModel> getAllPedidos() {
    return this.pedidoRepository.findAll();
  }

  public PedidoModel savePedido(PedidoModel pedido) {
    return this.pedidoRepository.save(pedido);
  }

  public Optional<PedidoModel> getPedidoById(Long id) {
    return this.pedidoRepository.findById(id);
  }

  public PedidoModel updateById(PedidoModel pedido, long id) {
    PedidoModel pedidoToUpdate = this.pedidoRepository.findById(id).get();
    pedidoToUpdate.setNombrecliente(pedido.getNombrecliente());
    pedidoToUpdate.setRamo(pedido.getRamo());
    pedidoToUpdate.setColor_ramo(pedido.getColor_ramo());
    pedidoToUpdate.setDireccion(pedido.getDireccion());
    pedidoToUpdate.setMensaje_compra(pedido.getMensaje_compra());
    pedidoToUpdate.setPrecio_ramo(pedido.getPrecio_ramo());
    return this.pedidoRepository.save(pedidoToUpdate);
  }

  public Boolean deletePedido(Long id) {
    try {
      this.pedidoRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
