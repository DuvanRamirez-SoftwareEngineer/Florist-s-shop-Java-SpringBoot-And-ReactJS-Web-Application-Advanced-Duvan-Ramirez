package com.iudigital.floristeriaapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "pedido")

public class PedidoModel {
  @Id
  @GeneratedValue (strategy= GenerationType.IDENTITY)

  private long id_pedido;
  private String color_ramo;
  private String direccion_entrega;
  private String mensaje_compra;
  private String nombrecliente;
  private double precio_ramo;
  private String direccion;
  private int ramo;


  public long getId_pedido() {
    return id_pedido;
  }
  public void setId_pedido(long id_pedido) {
    this.id_pedido = id_pedido;
  }
  public String getColor_ramo() {
    return color_ramo;
  }
  public void setColor_ramo(String color_ramo) {
    this.color_ramo = color_ramo;
  }
  public String getDireccion_entrega() {
    return direccion_entrega;
  }
  public void setDireccion_entrega(String direccion_entrega) {
    this.direccion_entrega = direccion_entrega;
  }
  public String getMensaje_compra() {
    return mensaje_compra;
  }
  public void setMensaje_compra(String mensaje_compra) {
    this.mensaje_compra = mensaje_compra;
  }
  public String getNombrecliente() {
    return nombrecliente;
  }
  public void setNombrecliente(String nombrecliente) {
    this.nombrecliente = nombrecliente;
  }
  public double getPrecio_ramo() {
    return precio_ramo;
  }
  public void setPrecio_ramo(double precio_ramo) {
    this.precio_ramo = precio_ramo;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public int getRamo() {
    return ramo;
  }
  public void setRamo(int ramo) {
    this.ramo = ramo;
  }
}