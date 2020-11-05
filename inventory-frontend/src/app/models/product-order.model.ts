/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 23:34:46
 * @modify date 2020-11-05 23:34:46
 * @desc [description]
 */

import { Warehouse } from './warehouse.model';

export class ProductOrder {
  productOrderId: number;
  quantity: number;
  pricePerUnit: number;
  qualityCheck: string;
  orderStatus: string;
  deliveryDate: string;
  manufactureDate: string;
  expiryDate: string;
  orderedOn: string;
  productId: number;
  productName: string;
  description: string;
  distributorId: number;
  distributorName: string;
  measurementUnit: string;
  warehouse: Warehouse;
}
