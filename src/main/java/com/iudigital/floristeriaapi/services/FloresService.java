package com.iudigital.floristeriaapi.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.floristeriaapi.models.FloresModel;
import com.iudigital.floristeriaapi.repositories.IFloresRepository;


@Service
public class FloresService {
  
  @Autowired
  private IFloresRepository floresRepository;
  public FloresService(IFloresRepository floresRepository){
    this.floresRepository=floresRepository;
  }
 
  public List<FloresModel> getAllFlores() {
    return  this.floresRepository.findAll();
  }

  public FloresModel saveFlor(FloresModel flor) {
    return this.floresRepository.save(flor);
  }

  public void deleteFlorById(long id_flor) {
    this.floresRepository.deleteById(id_flor);
  }



  public Optional<FloresModel> getFlorById(Long id) {
    return this.floresRepository.findById(id);
  }


  public FloresModel updateFlor(FloresModel flor) {
      return floresRepository.save(flor);
  }

  public FloresModel updateById(FloresModel flor, Integer id) {
    return this.floresRepository.save(flor);
  }

}
