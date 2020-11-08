import { Warehouse } from './warehouse.model';

/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-08 18:10:38
 * @modify date 2020-11-08 18:10:38
 * @desc [description]
 */
export class RawMaterialOrder {
  rawMaterialOrderId: number;
  quantity: number;
  pricePerUnit: number;
  qualityCheck: string;
  orderStatus: string;
  deliveryDate: string;
  expiryDate: string;
  orderedOn: string;
  materialName: string;
  description: string;
  supplierId: number;
  supplierName: string;
  measurementUnit: string;
  warehouse: Warehouse;
}
