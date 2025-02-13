import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'
import { AppRoutingModule } from './app-routing.module'
;
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AnimSliderComponent } from './anim-slider/anim-slider.component';
import { SignComponent } from './sign/sign.component';
import {FormsModule,ReactiveFormsModule} from "@angular/forms";
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { RegisterComponent } from './register/register.component';
import { VerifyOtpComponent } from './verify-otp/verify-otp.component';
import { NgXCreditCardsModule } from 'ngx-credit-cards';
import { ChartsModule } from 'ng2-charts';
import { NgxSpinnerModule } from 'ngx-spinner';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatAutocompleteModule,MatNativeDateModule,MatInputModule, MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatSelectModule, MatIconModule,MatDatepickerModule, MatDatepicker, MatTreeModule, MatStepperModule, MatDialog, MatDialogModule, MatSlideToggleModule, MatSliderModule} from '@angular/material';
import { RestaurantComponent, DialogDataExampleDialog } from './restaurant/restaurant.component';
import { SortCriteriaComponent } from './sort-criteria/sort-criteria.component';
import { SelectAutocompleteModule } from 'mat-select-autocomplete';
// import { NgxPayPalModule } from 'ngx-paypal';
import { HttpClientModule } from '@angular/common/http';
import {AgmCoreModule} from '@agm/core';
import { MapsService } from './maps.service';

import { PrefModelComponent } from './pref-model/pref-model.component';
import { FoodHomeComponent } from './food-home/food-home.component';
import { FoodRecomendComponent } from './food-recomend/food-recomend.component';
import { ReccoMendFoodComponent } from './recco-mend-food/recco-mend-food.component';
import { FoodCartComponent } from './food-cart/food-cart.component';
import { NewPaymentGatewayComponent } from './new-payment-gateway/new-payment-gateway.component';

import { LoggedRestaurantComponent } from './logged-restaurant/logged-restaurant.component';

import { LoggedInRestaurantComponent } from './logged-in-restaurant/logged-in-restaurant.component';
import { ChangePasswordComponent } from './change-password/change-password.component';


 


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    FooterComponent,
    AnimSliderComponent,
    SignComponent,
    CustomerProfileComponent,
    AboutUsComponent,
    RegisterComponent,
    VerifyOtpComponent,

    RestaurantComponent,
    SortCriteriaComponent,
    DialogDataExampleDialog,
    PrefModelComponent,
    FoodHomeComponent,
    FoodRecomendComponent,
    ReccoMendFoodComponent,

   
    FoodCartComponent,
    NewPaymentGatewayComponent,
    LoggedInRestaurantComponent,
    ChangePasswordComponent,

    LoggedRestaurantComponent,



  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    FormsModule,
    NgXCreditCardsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatInputModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
   
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    MatStepperModule,
    SelectAutocompleteModule,
    MatDialogModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatTreeModule,
    ChartsModule,
    MatSliderModule,
    NgxSpinnerModule,
   

    AgmCoreModule.forRoot({
      apiKey:'AIzaSyBpF7XNgiejLB4qxKJOnMKUNQEVtK6ke0Q'
    })    
  ],
 
  providers: [],
  bootstrap: [AppComponent,DialogDataExampleDialog],
  // entryComponents:
  // [
  //   RestaurantComponent,
  //   DialogDataExampleDialog,
  // ]
})
export class AppModule { }
