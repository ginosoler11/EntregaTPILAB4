import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ReporteAreas } from '../models/reportePorAreas';

@Injectable({
  providedIn: 'root',
})
export class ReporteService {
  dominio = 'reciboReporte/';
  apiURL = `${environment.base_URL}${this.dominio}`;
  constructor(private http: HttpClient) {}

  reportePorPeriodoDeTiempo(r: ReporteAreas): Observable<any> {
    return this.http.get(`${this.apiURL}?ano=${r.ano}&mes=${r.mes}`);
  }
}
