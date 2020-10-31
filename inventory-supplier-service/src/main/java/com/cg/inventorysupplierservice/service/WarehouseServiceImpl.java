package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorysupplierservice.dao.WarehouseDao;
import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.exception.DuplicateEntryException;
import com.cg.inventorysupplierservice.exception.EntityNotFoundException;
import com.cg.inventorysupplierservice.exception.InvalidDataException;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	boolean result;
	@Autowired
	private WarehouseDao wDao;
	
	@Override
	public Warehouse addWarehouse(WarehouseDto wh) {
		// TODO Auto-generated method stub
		
		Warehouse warehouse=mapper(wh);
		return wDao.save(warehouse);
	}


	@Override
	public List<Warehouse> getWarehouses() {
		// TODO Auto-generated method stub
		List<Warehouse> warehouses = wDao.findAll();
		if (warehouses == null)
			throw new EntityNotFoundException("Warehouse List","Not Found!");
		else
			return warehouses;
	}
	
	@Override
	public Optional<Warehouse> getWarehouseById(Long id) {
		// TODO Auto-generated method stub
		Optional<Warehouse> warehouse = null;
		warehouse = wDao.findById(id);
		if (!warehouse.isPresent())
			throw new EntityNotFoundException("Warehouse with Id  " + id , "Not Found! ");
		else
			return warehouse;
	}
	@Override
	public List<Warehouse> deleteWarehouseById(Long id) {
		// TODO Auto-generated method stub

		Optional<Warehouse> warehouse = null;
		warehouse = wDao.findById(id);
		if (!warehouse.isPresent())
			throw new EntityNotFoundException("Warehouse with Id  " + id , "Not Found!");
		else
			wDao.deleteById(id);
		return wDao.findAll();
	}
	
	@Override
	public Warehouse updateWarehouse( Long id, WarehouseDto warehouse) throws Exception {
		// TODO Auto-generated method stub
		Warehouse existingWarehouse = wDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Warehouse with Id " + id , "Not Found!"));
		
		existingWarehouse.setName(warehouse.getName());
		existingWarehouse.setDescription(warehouse.getDescription());
		return wDao.save(existingWarehouse);

		
	}


	@Override
	public Warehouse mapper(WarehouseDto wh) {
		
		Warehouse warehouse=new Warehouse();
		warehouse.setWarehouseId(wh.getWarehousId());
		warehouse.setName(wh.getName());
		warehouse.setDescription(wh.getDescription());
		
		return warehouse;
		
	}


}
