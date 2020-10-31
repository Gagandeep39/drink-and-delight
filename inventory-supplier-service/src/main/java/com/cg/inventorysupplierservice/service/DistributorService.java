package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.entity.Distributor;

public interface DistributorService {


	Distributor addDistributor(DistributorDto distributor);

	List<Distributor> getDistributors();

	Distributor updateDistributor(Long id, DistributorDto distributor);

	Optional<Distributor> getDistributorById(Long id);

	List<Distributor> deleteDistributorById(Long id);

	Distributor mapper(DistributorDto distributor);

}
