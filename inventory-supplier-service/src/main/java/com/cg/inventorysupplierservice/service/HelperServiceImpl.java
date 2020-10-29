package com.cg.inventorysupplierservice.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.inventorysupplierservice.dao.DistributorDao;
import com.cg.inventorysupplierservice.dao.SupplierDao;
import com.cg.inventorysupplierservice.dao.WarehouseDao;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;

@Service
public class HelperServiceImpl implements HelperService {

	@Autowired
	private DistributorDao dDao;
	@Autowired
	private SupplierDao sDao;
	@Autowired
	private WarehouseDao wDao;
	@Override
	public Warehouse addWarehouse(Warehouse wh) {
		// TODO Auto-generated method stub
		
		
		return wDao.save(wh);
	}
	@Override
	public Distributor addDistributor(Distributor distributor) {
		// TODO Auto-generated method stub
		return dDao.save(distributor);
	}
	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return sDao.save(supplier);
	}
	@Override
	public List<Warehouse> getWarehouses() {
		// TODO Auto-generated method stub
		return wDao.findAll();
	}
	@Override
	public List<Distributor> getDistributors() {
		// TODO Auto-generated method stub
		return dDao.findAll();
	}
	@Override
	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return sDao.findAll();
	}
	@Override
	public boolean validateWarehouse(Warehouse wh) {
		// TODO Auto-generated method stub
		String tempName=wh.getName();
		String tempDescription=wh.getDescription();
		if(tempName!=""&&tempDescription!="")
			return true;
		else
		return false;
	}
	@Override
	public boolean validateDistributor(Distributor distributor) {
		// TODO Auto-generated method stub
		String tempName=distributor.getMaterialName();
		String tempDescription=distributor.getDescription();
		if(tempName!=""&&tempDescription!="")
			return true;
		else
		return false;
	}
	@Override
	public boolean validateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		String tempName=supplier.getName();
		String templocation=supplier.getLocation();
		String tempNo=supplier.getPhoneNo();
		if(tempName!=""&&templocation!="")
		{
			return true;
		}
		
		return false;
	}
	@Override
	public boolean validateMobileNo(Supplier supplier) {
		// TODO Auto-generated method stub
		String tempNo=supplier.getPhoneNo();
		String regex="(0/91)?[7-9][0-9]{9}";
		
		return tempNo.matches(regex);
	}

}