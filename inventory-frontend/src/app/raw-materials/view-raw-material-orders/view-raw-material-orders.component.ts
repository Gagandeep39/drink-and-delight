import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { ProductOrder } from 'src/app/models/product-order.model';
import { RawMaterialOrder } from 'src/app/models/rawmaterial-order.model';
import { LoadingService } from 'src/app/services/loading.service';
import { ProductOrderService } from 'src/app/services/product-order.service';
import { RawmaterialOrderService } from 'src/app/services/rawmaterial-order.service';
import { UpdateStatusComponent } from 'src/app/shared/update-status/update-status.component';

@Component({
  selector: 'app-view-raw-material-orders',
  templateUrl: './view-raw-material-orders.component.html',
  styleUrls: ['./view-raw-material-orders.component.css']
})
export class ViewRawMaterialOrdersComponent implements OnInit {

  dataSource = new MatTableDataSource<RawMaterialOrder>();
  @ViewChild(MatSort, { static: false }) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  // Specify columns tht should be rendered, must match names of matColumnDef
  // ID is not beign displayed as its not present here 
  displayedColumns: string[] = [
    'rawMaterialOrderId',
    'materialName',
    'pricePerUnit',
    'orderedOn',
    'supplierName',
    'quantity',
    'orderStatus',
  ];
  userSubscription: Subscription;

  constructor(
    private rawMaterialOrderService: RawmaterialOrderService,
    public loadingService: LoadingService,
    private dialogRef: MatDialog
  ) {}

  ngOnInit(): void {
    this.fetchAllRawMaterials();
  }
  fetchAllRawMaterials () {
    this.loadingService.enableLoading();
    this.userSubscription = this.rawMaterialOrderService
      .fetchAllRawMaterialOrders()
      .subscribe((response: RawMaterialOrder[]) => {
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
      this.fetchAllRawMaterials();
    })
  }
}
