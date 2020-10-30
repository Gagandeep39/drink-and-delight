package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorysupplierservice.dao.SupplierDao;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.exception.EntityNotFoundException;
import com.cg.inventorysupplierservice.exception.InvalidDataException;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao sDao;

	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		if (validateSupplier(supplier)) {
			if (validatePhoneNo(supplier))
				return sDao.save(supplier);
			else
				throw new InvalidDataException("Mobile No", "Invalid format");
		} else
			throw new InvalidDataException("Parameter Value ", "Cannot be null!");
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
	public Supplier updateSupplier(Long id, Supplier supplier) {
		// TODO Auto-generated method stub
		Supplier existingSupplier = sDao.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Supplier with Id " + id, "Not Found"));
		if (validateSupplier(supplier) && validatePhoneNo(supplier)) {
			existingSupplier.setName(supplier.getName());
			existingSupplier.setLocation(supplier.getLocation());
			existingSupplier.setPhoneNo(supplier.getPhoneNo());

			return sDao.save(existingSupplier);
		} else
			throw new InvalidDataException("Parameter value", "Invalid Data Exception");

	}

	public boolean validateSupplier(Supplier supplier) {

		String tempName = supplier.getName();
		String tempLocation = supplier.getLocation();
		if (tempName != "" && tempLocation != "" && tempName != null && tempLocation != null)
			return true;
		else
			return false;
	}

	public boolean validatePhoneNo(Supplier supplier) {
		String tempNo = supplier.getPhoneNo();
		String regex = "(0/91)?[7-9][0-9]{9}";

		return tempNo.matches(regex);
	}

}
