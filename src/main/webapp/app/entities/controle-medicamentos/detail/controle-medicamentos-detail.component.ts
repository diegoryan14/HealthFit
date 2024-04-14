import { Component, input } from '@angular/core';
import { RouterModule } from '@angular/router';

import SharedModule from 'app/shared/shared.module';
import { DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe } from 'app/shared/date';
import { IControleMedicamentos } from '../controle-medicamentos.model';

@Component({
  standalone: true,
  selector: 'app-controle-medicamentos-detail',
  templateUrl: './controle-medicamentos-detail.component.html',
  imports: [SharedModule, RouterModule, DurationPipe, FormatMediumDatetimePipe, FormatMediumDatePipe],
})
export class ControleMedicamentosDetailComponent {
  controleMedicamentos = input<IControleMedicamentos | null>(null);

  previousState(): void {
    window.history.back();
  }
}
