import { Routes } from '@angular/router';
import { ComprasComponent } from './components/compras/compras.component';

export const routes: Routes = [
  { path: 'compras', component: ComprasComponent },
  { path: '', redirectTo: 'compras', pathMatch: 'full' }
];
