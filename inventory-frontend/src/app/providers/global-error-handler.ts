/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-04 19:04:57
 * @modify date 2020-11-04 19:04:57
 * @desc Global rror Handlers
 */
import { Injectable, ErrorHandler } from '@angular/core';
import { ErrorDialogService } from '../services/error-dialog.service';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {
  constructor(private errorDialogService: ErrorDialogService) {}

  handleError(error: Error) {
    this.errorDialogService.openDialog(
      error.message || 'Undefined client error'
    );
  }
}
