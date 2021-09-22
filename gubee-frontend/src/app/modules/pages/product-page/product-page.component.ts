import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {ProductDto} from "../../dto/product-dto";
import {ProductService} from "../../services/product.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  dataSource = new MatTableDataSource<ProductDto>();
  displayedColumns = ['productName', 'description', 'targetMarket', 'stack'];
  toppings = new FormControl();
  toppingList: string[] = ['Java 10', 'Kotlin', 'Kafka', 'Event Stream', 'Redis', 'MongoDB', 'NodeJS',
    "Big Data Analytics", "Hadoop", "Kafka", "Pig", "Cassandra"];

  constructor(
    private productService: ProductService,
  ) {
  }

  ngOnInit(): void {
    this._loadData();
  }

  private _loadData(): void {
    this.productService.findAll().subscribe(value =>
      this.dataSource.data = value
    );
  }

  public loadFilteredData(): void {
    this.productService.listByStack(this.toppings.value).subscribe(value =>
      this.dataSource.data = value
    )
  }

}
