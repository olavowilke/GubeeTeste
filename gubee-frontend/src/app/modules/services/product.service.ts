import {Injectable} from "@angular/core";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductDto} from "../dto/product-dto";

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private url = `${environment.baseUrl}/products`;

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<ProductDto[]> {
    return this.http.get<ProductDto[]>(`${this.url}`)
  }

  listByStack(value: string[]): Observable<ProductDto[]> {
    return this.http.post<ProductDto[]>(`${this.url}/stack`, value)
  }

}
