import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AltaComponent } from './empleado/alta/alta.component';
import { ListadoComponent } from './empleado/listado/listado.component';
import { HomeComponent } from './home/home.component';
import { AltaRecibosComponent } from './recibos/alta-recibos/alta-recibos.component';
import { ListadoRecibosComponent } from './recibos/listado-recibos/listado-recibos.component';
import { ReportesComponent } from './reportes/reportes.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'listado-empleados', component: ListadoComponent },
  { path: 'nuevo-empleado', component: AltaComponent },
  { path: 'listado-recibos', component: ListadoRecibosComponent },
  { path: 'nuevo-recibo', component: AltaRecibosComponent },
  { path: 'reportes', component: ReportesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
