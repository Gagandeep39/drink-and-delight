package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.inventorysupplierservice.entity.Distributor;

public interface DistributorService {

	Distributor addDistributor(Distributor distributor);

	List<Distributor> getDistributors();

	Distributor updateDistributor(Long id, Distributor distributor);

	Optional<Distributor> getDistributorById(Long id);

	List<Distributor> deleteDistributorById(Long id);

}
