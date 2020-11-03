/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:03:26
 * @modify date 2020-11-02 01:03:26
 * @desc Distributor Service Implementation
 */
package com.cg.inventorysupplierservice.service.implementation;

import java.util.List;

import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.exception.NotFoundException;
import com.cg.inventorysupplierservice.helper.GenericMapper;
import com.cg.inventorysupplierservice.repository.DistributorRepository;
import com.cg.inventorysupplierservice.service.DistributorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributorServiceImpl implements DistributorService {

  @Autowired
  private DistributorRepository repository;

  @Override
  public Distributor addDistributor(DistributorDto distributor) {
    return repository.save(GenericMapper.distributorDtoToEntity(distributor));
  }

  @Override
  public List<Distributor> getDistributors() {
    return repository.findAll();
  }

  @Override
  public Distributor getDistributorById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("distributorId", "Distributor Not found"));
  }

}
