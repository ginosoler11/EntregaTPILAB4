import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Recibo } from '../models/recibo';

@Injectable({
  providedIn: 'root',
})
export class ReciboService {
  dominio = 'recibos/';
  apiURL = `${environment.base_URL}${this.dominio}`;
  constructor(private http: HttpClient) {}

  reciboPorLegajo(legajo: number): Observable<Recibo[]> {
    return this.http.get<Recibo[]>(this.apiURL + legajo);
  }

  agregarRecibo(recibo: Recibo): Observable<any> {
    return this.http.post(this.apiURL, recibo, { responseType: 'text' });
  }
}
