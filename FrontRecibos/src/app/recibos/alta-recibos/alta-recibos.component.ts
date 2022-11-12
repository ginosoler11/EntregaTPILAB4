import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Recibo } from 'src/app/models/recibo';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { ReciboService } from 'src/app/services/recibo.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-alta-recibos',
  templateUrl: './alta-recibos.component.html',
  styleUrls: ['./alta-recibos.component.css'],
})
export class AltaRecibosComponent implements OnInit {
  formulario: FormGroup;
  empleados: any[];
  meses = [
    { numero: 1, mes: 'Enero' },
    { numero: 2, mes: 'Febrero' },
    { numero: 3, mes: 'Marzo' },
    { numero: 4, mes: 'Abril' },
    { numero: 5, mes: 'Mayo' },
    { numero: 6, mes: 'Junio' },
    { numero: 7, mes: 'Julio' },
    { numero: 8, mes: 'Agosto' },
    { numero: 9, mes: 'Septiembre' },
    { numero: 10, mes: 'Octubre' },
    { numero: 11, mes: 'Noviembre' },
    { numero: 12, mes: 'Diciembre' },
  ];
  private subs = new Subscription();

  constructor(
    private reciboService: ReciboService,
    private empleadoService: EmpleadoService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.formulario = this.formBuilder.group({
      ano: ['', Validators.required],
      mes: ['', Validators.required],
      sueldoBruto: ['', Validators.required],
      montoAntiguedad: ['', Validators.required],
      montoJubilacion: ['', Validators.required],
      montoObraSocial: ['', Validators.required],
      montoFAC: ['', Validators.required],
      empleado: ['', Validators.required],
    });

    this.subs.add(
      this.empleadoService.obtenerEmpleadoSolo().subscribe({
        next: (emps: any[]) => {
          this.empleados = emps;
        },
      })
    );
  }

  registrarRecibo() {
    this.subs.add(
      this.reciboService
        .agregarRecibo(this.formulario.value as Recibo)
        .subscribe({
          next: () => {
            Swal.fire(
              'Registro exitoso!',
              'Recibo registrado con exito.',
              'success'
            );
          },
          error: () => {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'No se pudo registrar su recibo!',
            });
          },
        })
    );
  }
}
