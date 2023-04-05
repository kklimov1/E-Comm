import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductListsComponent } from './product-lists.component';
import { HttpClientModule } from '@angular/common/http';

describe('ProductListsComponent', () => {
  let component: ProductListsComponent;
  let fixture: ComponentFixture<ProductListsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule],
      declarations: [ ProductListsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductListsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
