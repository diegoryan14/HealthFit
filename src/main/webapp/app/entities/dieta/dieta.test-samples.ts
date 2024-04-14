import dayjs from 'dayjs/esm';

import { IDieta, NewDieta } from './dieta.model';

export const sampleWithRequiredData: IDieta = {
  id: 15135,
};

export const sampleWithPartialData: IDieta = {
  id: 25420,
  descricaoRefeicao: 'boohoo',
  dataHorarioRefeicao: dayjs('2024-04-14T03:24'),
  caloriasConsumidas: 16866,
};

export const sampleWithFullData: IDieta = {
  id: 9891,
  descricaoRefeicao: 'muster um possibility',
  dataHorarioRefeicao: dayjs('2024-04-13T15:30'),
  caloriasConsumidas: 10913,
};

export const sampleWithNewData: NewDieta = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
