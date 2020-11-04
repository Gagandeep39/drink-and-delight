import { Warehouse } from './warehouse.model';

export class RawMaterial {
    materialName : string;
    productId : number;
    description : string;
    quantityAvailable : number;
    quantityUnit : string;
    warehouse : Warehouse;
}
