import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../plasma.material.modules.ts/material.module';
// import { StyleManager } from './style-manager';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    MaterialModule
  ],
  providers: [
    // StyleManager
  ]
})
export class SharedModule { }
