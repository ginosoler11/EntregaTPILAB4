import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {
  dominio = 'empleados/';
  apiURL = `${environment.base_URL}${this.dominio}`;

  constructor(private http: HttpClient) {}

  obtenerEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.apiURL);
  }

  obtenerEmpleadoSolo(): Observable<any> {
    return this.http.get(`${environment.base_URL}empleado`);
  }

  obtenerEmpleadoPorLegajo(legajo: number): Observable<any> {
    return this.http.get(environment.base_URL + 'hayempleado?legajo=' + legajo);
  }

  agregarEmpleado(emp: Empleado): Observable<any> {
    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*');
    return this.http.post(this.apiURL, emp, {
      headers: headers,
      responseType: 'text',
    });
  }
}
