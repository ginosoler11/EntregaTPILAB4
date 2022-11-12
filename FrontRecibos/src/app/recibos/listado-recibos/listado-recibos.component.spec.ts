import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoRecibosComponent } from './listado-recibos.component';

describe('ListadoRecibosComponent', () => {
  let component: ListadoRecibosComponent;
  let fixture: ComponentFixture<ListadoRecibosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoRecibosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoRecibosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
