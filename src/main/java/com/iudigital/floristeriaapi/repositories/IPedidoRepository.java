package com.iudigital.floristeriaapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.floristeriaapi.models.PedidoModel;

@Repository
public interface IPedidoRepository extends JpaRepository<PedidoModel, Long>{
    @Override
    public List<PedidoModel> findAll();


  
}

