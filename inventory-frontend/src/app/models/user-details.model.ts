import { Address } from './address.model';

/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-05 00:41:17
 * @modify date 2020-11-05 00:41:17
 * @desc User detals model
 */
export class UserDetails {
  userId: string;
  username: string;
  role: string;
  designation: string;
  gender: string;
  emailId: string;
  phoneNo: string;
  dob: string;
  address: Address;
  firstName: string;
  lastName: string;
}
