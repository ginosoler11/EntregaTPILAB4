import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AltaComponent } from './empleado/alta/alta.component';
import { ListadoComponent } from './empleado/listado/listado.component';
import { ListadoRecibosComponent } from './recibos/listado-recibos/listado-recibos.component';
import { ReportesComponent } from './reportes/reportes.component';
import { AltaRecibosComponent } from './recibos/alta-recibos/alta-recibos.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EmpleadoService } from './services/empleado.service';
import { ReciboService } from './services/recibo.service';
import { ReporteService } from './services/reporte.service';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    NavbarComponent,
    AltaComponent,
    ListadoComponent,
    ListadoRecibosComponent,
    ReportesComponent,
    AltaRecibosComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [EmpleadoService, ReciboService, ReporteService],
  bootstrap: [AppComponent],
})
export class AppModule {}
