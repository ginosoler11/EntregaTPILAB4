import { Injectable } from '@angular/core';
import {
  AbstractControl,
  AsyncValidator,
  ValidationErrors,
} from '@angular/forms';
import { catchError, map, Observable, of } from 'rxjs';
import { EmpleadoService } from '../services/empleado.service';

@Injectable({ providedIn: 'root' })
export class legajoValidator implements AsyncValidator {
  constructor(private empleadoService: EmpleadoService) {}

  validate(control: AbstractControl): Observable<ValidationErrors | null> {
    return this.empleadoService.obtenerEmpleadoPorLegajo(control.value).pipe(
      map((isTakenasdasd) => (isTakenasdasd ? { legajoExists: true } : null)),
      catchError(() => of(null))
    );
  }
}
