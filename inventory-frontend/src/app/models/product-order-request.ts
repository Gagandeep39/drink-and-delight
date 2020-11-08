/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-08 18:02:54
 * @modify date 2020-11-08 18:02:54
 * @desc Created product order request entity
 */
export class ProductOrderRequest {
  productId: number;
  quantity: number;
  pricePerUnit: number;
  qualityCheck: string;
  deliveryDate: string;
  expiryDate: string;
  manufactureDate: string;
  distributorId: number;
}
