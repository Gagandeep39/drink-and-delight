package com.cg.inventorysupplierservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.inventorysupplierservice.dao.DistributorDao;
import com.cg.inventorysupplierservice.dao.SupplierDao;
import com.cg.inventorysupplierservice.dao.WarehouseDao;
import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.dto.SupplierDto;
import com.cg.inventorysupplierservice.dto.WarehouseDto;
import com.cg.inventorysupplierservice.entity.Distributor;
import com.cg.inventorysupplierservice.entity.Supplier;
import com.cg.inventorysupplierservice.entity.Warehouse;
import com.cg.inventorysupplierservice.service.DistributorService;
//import com.cg.inventorysupplierservice.service.HelperService;
import com.cg.inventorysupplierservice.service.SupplierService;
import com.cg.inventorysupplierservice.service.WarehouseService;
import com.thoughtworks.xstream.mapper.Mapper;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(value=SupplierController.class )
public class InventorySupplierServiceApplicationTests {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private DistributorService distributorService;

	@Autowired
	private WarehouseService warehouseService;

	@MockBean
	private WarehouseDao wDao;
	@MockBean
	private DistributorDao dDao;
	@MockBean
	private SupplierDao sDao;

	@Test
	public void getWarehousesTest() {
		when(wDao.findAll()).thenReturn(Stream
				.of(new Warehouse((long) 100000, "Milk Product warehouse", "All milk products"),
						new Warehouse((long) 100001, "COLD DRINKS warehouse", "All COLD Drinks"))
				.collect(Collectors.toList()));
		assertEquals(2, warehouseService.getWarehouses().size());
	}

	@Test
	public void addWarehouseWithCorrectFieldsTest() {

		WarehouseDto warehouse = new WarehouseDto((long) 100000, "Milk Product warehouse", "All milk products");
		Warehouse wh=null;
		wh=warehouseService.mapper(warehouse);
		when(wDao.save(wh)).thenReturn(wh);
		assertEquals(wh, warehouseService.addWarehouse(warehouse));
	}

	

	@Test
	public void getDistributorsTest() {
		when(dDao.findAll()).thenReturn(Stream
				.of(new Distributor((long) 100000, "Lassi", "Milk Product"),
						new Distributor((long) 100001, "Mango Milkshake", "Milk Product"))
				.collect(Collectors.toList()));
		assertEquals(2, distributorService.getDistributors().size());
	}

	@Test
	public void addDistributorWithCorrectFieldsTest() {

		DistributorDto distributor = new DistributorDto((long) 100000, "Lassi", "Milk Product");
		Distributor dt=new Distributor();
		dt=distributorService.mapper(distributor);
		when(dDao.save(dt)).thenReturn(dt);
		assertEquals(dt, distributorService.addDistributor(distributor));
	}

	@Test
	public void getSuppliersTest() {
		when(sDao.findAll()).thenReturn(Stream
				.of(new Supplier((long) 100000, "AK Supplier", "Pune", "9988776767"),
						new Supplier((long) 100001, "RJ Supplier", "Mumbai", "8788887878"))
				.collect(Collectors.toList()));
		assertEquals(2, supplierService.getSuppliers().size());
	}

	@Test
	public void addSupplierWithCorrectFieldsTest() {

		SupplierDto supplier = new SupplierDto((long) 100000, "AK Supplier", "Pune", "9988776767");
		Supplier sp = new Supplier((long) 100000, "AK Supplier", "Pune", "9988776767");
		
		//Supplier sp=null;
		//sp=supplierService.mapper(supplier);
		when(sDao.save(sp)).thenReturn(sp);
		assertEquals(sp, supplierService.addSupplier(supplier));
	}
	
	
	
	

}
