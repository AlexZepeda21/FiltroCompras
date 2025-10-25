import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CompraService } from '../../services/compra.service'; 

@Component({
  selector: 'app-compras',
  standalone: true,
  templateUrl: './compras.component.html',
  styleUrls: ['./compras.component.css'],
  imports: [FormsModule, CommonModule]
})
export class ComprasComponent implements OnInit {
  idComercio: number | null = null;
  fecha: string = '';
  medioPago: string = '';
  compras: any[] = [];

  constructor(private compraService: CompraService) {}

  ngOnInit(): void {
    this.cargarCompras();
  }

  cargarCompras(): void {
    this.compraService.getCompras().subscribe({
      next: (data) => this.compras = data,
      error: (err) => console.error('Error al cargar las compras:', err)
    });
  }

  buscar(): void {
    if (this.idComercio != null && this.fecha && this.medioPago) {
      this.compraService.buscarCompras(this.idComercio, this.fecha, this.medioPago).subscribe({
        next: (data) => this.compras = data,
        error: (err) => console.error('Error al buscar compras:', err)
      });
    } else {
      console.warn('Debe completar todos los campos para buscar');
    }
  }
}
