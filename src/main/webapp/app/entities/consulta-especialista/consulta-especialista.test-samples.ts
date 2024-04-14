import dayjs from 'dayjs/esm';

import { IConsultaEspecialista, NewConsultaEspecialista } from './consulta-especialista.model';

export const sampleWithRequiredData: IConsultaEspecialista = {
  id: 20166,
};

export const sampleWithPartialData: IConsultaEspecialista = {
  id: 233,
  statusConsulta: 'CONFIRMADA',
};

export const sampleWithFullData: IConsultaEspecialista = {
  id: 6407,
  tipoEspecialista: 'NUTRICIONISTA',
  dataHorarioConsulta: dayjs('2024-04-14T03:52'),
  statusConsulta: 'ADIADA',
};

export const sampleWithNewData: NewConsultaEspecialista = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
