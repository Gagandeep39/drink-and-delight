/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-11-08 13:56:28
 * @modify date 2020-11-08 13:56:28
 * @desc View Product Orers
 */
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { ProductOrder } from 'src/app/models/product-order.model';
import { LoadingService } from 'src/app/services/loading.service';
import { ProductOrderService } from 'src/app/services/product-order.service';
import { UpdateStatusComponent } from 'src/app/shared/update-status/update-status.component';

@Component({
  selector: 'app-view-product-orders',
  templateUrl: './view-product-orders.component.html',
  styleUrls: ['./view-product-orders.component.css'],
})
export class ViewProductOrdersComponent implements OnInit {
  dataSource = new MatTableDataSource<ProductOrder>();
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  // Specify columns tht should be rendered, must match names of matColumnDef
  // ID is not beign displayed as its not present here 
  displayedColumns: string[] = [
    'productOrderId',
    'productName',
    'pricePerUnit',
    'orderedOn',
    'distributorName',
    'quantity',
    'orderStatus',
  ];
  userSubscription: Subscription;

  constructor(
    private productOrderService: ProductOrderService,
    public loadingService: LoadingService,
    private dialogRef: MatDialog
  ) {}

  ngOnInit(): void {
    this.fetchAllUsers();
  }
  fetchAllUsers() {
    this.loadingService.enableLoading();
    this.userSubscription = this.productOrderService
      .fetchAllProductOrders()
      .subscribe((response: ProductOrder[]) => {
        this.dataSource.data = response;
        this.loadingService.disableLoading();
      });
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  doFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

  updateStatus(element) {
    const dialogRef = this.dialogRef.open(UpdateStatusComponent, {
      data: element
    })
    dialogRef.afterClosed().subscribe(result => {
      this.fetchAllUsers();
    })
  }
}
