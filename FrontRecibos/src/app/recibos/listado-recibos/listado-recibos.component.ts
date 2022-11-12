import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Recibo } from 'src/app/models/recibo';
import { ReciboService } from 'src/app/services/recibo.service';

@Component({
  selector: 'app-listado-recibos',
  templateUrl: './listado-recibos.component.html',
  styleUrls: ['./listado-recibos.component.css'],
})
export class ListadoRecibosComponent implements OnInit {
  listado: any[];
  legajo: number;
  private subs = new Subscription();
  constructor(private recService: ReciboService) {}

  ngOnInit(): void {}

  consultarLegajo() {
    this.subs.add(
      this.recService.reciboPorLegajo(this.legajo).subscribe({
        next: (recibos: Recibo[]) => {
          console.log(recibos);
          this.listado = recibos;
        },
      })
    );
  }
}
