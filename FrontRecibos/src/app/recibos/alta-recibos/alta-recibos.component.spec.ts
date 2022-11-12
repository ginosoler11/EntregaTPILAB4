import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AltaRecibosComponent } from './alta-recibos.component';

describe('AltaRecibosComponent', () => {
  let component: AltaRecibosComponent;
  let fixture: ComponentFixture<AltaRecibosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AltaRecibosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AltaRecibosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
