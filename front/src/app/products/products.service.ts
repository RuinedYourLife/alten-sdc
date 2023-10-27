import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  Observable } from 'rxjs';
import { Product } from './product.class';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
    private BASE_URL = environment.apiUrl + '/product';

    constructor(private http: HttpClient) { }

    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.BASE_URL);
    }

    create(product: Product): Observable<Product> {
        if (!product.id) delete product.id;
        return this.http.post<Product>(this.BASE_URL, product);
    }

    update(product: Product): Observable<Product>{
        const updateUrl = `${this.BASE_URL}/${product.id}`;
        return this.http.patch<Product>(updateUrl, product);
    }

    delete(id: number): Observable<void>{
        const deleteUrl = `${this.BASE_URL}/${id}`;
        return this.http.delete<void>(deleteUrl);
    }
}
