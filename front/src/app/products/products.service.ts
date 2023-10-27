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

    create(prod: Product): Observable<Product> {
        return this.http.post<Product>(this.BASE_URL, prod);
    }

    update(prod: Product): Observable<Product>{
        const updateUrl = `${this.BASE_URL}/${prod.id}`;
        return this.http.patch<Product>(updateUrl, prod);
    }

    delete(id: number): Observable<void>{
        const deleteUrl = `${this.BASE_URL}/${id}`;
        return this.http.delete<void>(deleteUrl);
    }
}
