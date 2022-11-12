import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { legajoValidator } from 'src/app/validators/legajoValidator';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-alta',
  templateUrl: './alta.component.html',
  styleUrls: ['./alta.component.css'],
})
export class AltaComponent implements OnInit {
  private subs = new Subscription();
  formulario: FormGroup;
  constructor(
    private empleadoService: EmpleadoService,
    private router: Router,
    private formBuilder: FormBuilder,
    private legajoValidado: legajoValidator
  ) {}

  ngOnInit(): void {
    this.formulario = this.formBuilder.group({
      legajo: [
        '',
        {
          Validators: ['', Validators.required],
          asyncValidators: [this.legajoValidado],
          updateOn: 'blur',
        },
      ],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
      fechaIngreso: ['', Validators.required],
      area: ['', Validators.required],
      sueldoBruto: ['', Validators.required],
    });
  }

  registrarEmpleado() {
    if (this.formulario.valid) {
      this.subs.add(
        this.empleadoService
          .agregarEmpleado(this.formulario.value as Empleado)
          .subscribe({
            next: () => {
              Swal.fire(
                'Registro exitoso!',
                'Se registro el empleado con éxito.',
                'success'
              );
              this.router.navigate(['/listado-empleados']);
            },
            error: () => {
              Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'No se pudo dar de alta el empleado!',
              });
            },
          })
      );
    }
  }
}
