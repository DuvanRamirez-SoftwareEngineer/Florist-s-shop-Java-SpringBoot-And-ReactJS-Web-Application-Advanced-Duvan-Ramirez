package com.iudigital.floristeriaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.floristeriaapi.models.FloresModel;

@Repository
public interface IFloresRepository extends JpaRepository<FloresModel, Long>{

  
}
