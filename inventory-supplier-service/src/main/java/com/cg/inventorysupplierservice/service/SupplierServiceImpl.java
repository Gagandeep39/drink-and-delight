package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorysupplierservice.dao.SupplierDao;
import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.exception.EntityNotFoundException;
import com.cg.inventorysupplierservice.exception.InvalidDataException;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao sDao;

	@Override
	public Supplier addSupplier(SupplierDto supplier) {
		// TODO Auto-generated method stub
		Supplier sp=new Supplier();
		sp.setSupplierId(supplier.getSupplierId());
		sp.setName(supplier.getName());
		sp.setLocation(supplier.getLocation());
		sp.setPhoneNo(supplier.getPhoneNo());
		
		return sDao.save(sp);
		}


	@Override
	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		List<Supplier> suppliers = sDao.findAll();
		if (suppliers == null)
			throw new EntityNotFoundException("Suppliers List!", "Not Found!");
		return suppliers;
	}

	@Override
	public Optional<Supplier> getSupplierById(Long id) {
		// TODO Auto-generated method stub
		Optional<Supplier> supplier = null;
		supplier = sDao.findById(id);
		if (!supplier.isPresent())
			throw new EntityNotFoundException("Supplier with Id " + id, "Not Found!");
		else
			return supplier;
	}

	@Override
	public List<Supplier> deleteSupplierById(Long id) {
		// TODO Auto-generated method stub
		Optional<Supplier> supplier = null;
		supplier = sDao.findById(id);
		if (!supplier.isPresent())
			throw new EntityNotFoundException("Supplier with Id " + id, " Not Found!");
		else
			sDao.deleteById(id);
		return sDao.findAll();
	}

	@Override
	public Supplier updateSupplier(Long id, SupplierDto supplier) {
		// TODO Auto-generated method stub
		Supplier existingSupplier = sDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Supplier with Id " + id, "Not Found"));
			existingSupplier.setName(supplier.getName());
			existingSupplier.setLocation(supplier.getLocation());
			existingSupplier.setPhoneNo(supplier.getPhoneNo());

			return sDao.save(existingSupplier);
	
	}


	@Override
	public Supplier mapper(SupplierDto supplier) {
		// TODO Auto-generated method stub
		Supplier sp=new Supplier();
		sp.setSupplierId(supplier.getSupplierId());
		sp.setName(supplier.getName());
		sp.setLocation(supplier.getLocation());
		sp.setPhoneNo(supplier.getPhoneNo());
		
		return sp;
	}

}
