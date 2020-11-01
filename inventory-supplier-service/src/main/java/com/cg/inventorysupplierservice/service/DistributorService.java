/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-02 01:02:08
 * @modify date 2020-11-02 01:02:08
 * @desc Distributer management Service
 */
package com.cg.inventorysupplierservice.service;

import java.util.List;

import com.cg.inventorysupplierservice.dto.DistributorDto;
import com.cg.inventorysupplierservice.entity.Distributor;

public interface DistributorService {

	Distributor addDistributor(DistributorDto distributor);

	List<Distributor> getDistributors();

	Distributor getDistributorById(Long id);

}
