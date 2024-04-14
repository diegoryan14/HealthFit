import dayjs from 'dayjs/esm';

import { IUsuario, NewUsuario } from './usuario.model';

export const sampleWithRequiredData: IUsuario = {
  id: 31954,
};

export const sampleWithPartialData: IUsuario = {
  id: 3762,
  plano: 'PRATA',
  dataRegistro: dayjs('2024-04-13T09:50'),
};

export const sampleWithFullData: IUsuario = {
  id: 20195,
  plano: 'OURO',
  dataRegistro: dayjs('2024-04-13T21:36'),
};

export const sampleWithNewData: NewUsuario = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
