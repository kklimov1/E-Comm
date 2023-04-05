import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductListsComponent } from '../product-lists/product-lists.component';
import { HomePageComponent } from './home-page.component';
import { HttpClientModule } from '@angular/common/http';

describe('HomePageComponent', () => {
  let component: HomePageComponent;
  let fixture: ComponentFixture<HomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ HttpClientModule],
      declarations: [ HomePageComponent, ProductListsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
