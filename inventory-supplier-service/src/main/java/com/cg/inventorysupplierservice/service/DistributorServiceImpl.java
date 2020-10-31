package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorysupplierservice.dao.DistributorDao;
import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.exception.EntityNotFoundException;
import com.cg.inventorysupplierservice.exception.InvalidDataException;

@Service
public class DistributorServiceImpl implements DistributorService {

	@Autowired
	private DistributorDao dDao;

	@Override
	public Distributor addDistributor(DistributorDto distributor) {
		// TODO Auto-generated method stub
		Distributor dt = new Distributor();
		dt.setDistributorId(distributor.getDistributorId());
		dt.setMaterialName(distributor.getMaterialName());
		dt.setDescription(distributor.getDescription());

		return dDao.save(dt);
	}

	@Override
	public List<Distributor> getDistributors() {
		// TODO Auto-generated method stub
		List<Distributor> distributors = dDao.findAll();
		if (distributors == null)
			throw new EntityNotFoundException("List of distributors", "Not Found!");
		return distributors;
	}

	@Override
	public Optional<Distributor> getDistributorById(Long id) {
		// TODO Auto-generated method stub
		Optional<Distributor> distributor = null;
		distributor = dDao.findById(id);
		if (!distributor.isPresent())
			throw new EntityNotFoundException("Distributor with Id  " + id, "Not Found!");
		else
			return distributor;
	}

	@Override
	public List<Distributor> deleteDistributorById(Long id) {
		// TODO Auto-generated method stub
		Optional<Distributor> distributor = null;
		distributor = dDao.findById(id);
		if (!distributor.isPresent())
			throw new EntityNotFoundException("Distributor with Id  " + id, "Not Found!");
		else
			dDao.deleteById(id);
		return dDao.findAll();
	}

	@Override
	public Distributor updateDistributor(Long id, DistributorDto distributor) {
		// TODO Auto-generated method stub
		Distributor existingDistributor = dDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Distributor with Id " + id, "Not Found!"));

		existingDistributor.setMaterialName(distributor.getMaterialName());
		existingDistributor.setDescription(distributor.getDescription());

		return dDao.save(existingDistributor);

	}


	@Override
	public Distributor mapper(DistributorDto distributor) {

		Distributor dt = new Distributor();
		dt.setDistributorId(distributor.getDistributorId());
		dt.setMaterialName(distributor.getMaterialName());
		dt.setDescription(distributor.getDescription());

		return dt;

	}

}
