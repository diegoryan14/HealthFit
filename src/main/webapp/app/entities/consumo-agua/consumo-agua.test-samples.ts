import dayjs from 'dayjs/esm';

import { IConsumoAgua, NewConsumoAgua } from './consumo-agua.model';

export const sampleWithRequiredData: IConsumoAgua = {
  id: 6954,
};

export const sampleWithPartialData: IConsumoAgua = {
  id: 31212,
  dataConsumo: dayjs('2024-04-28T01:12'),
  quantidadeMl: 27525,
};

export const sampleWithFullData: IConsumoAgua = {
  id: 26889,
  dataConsumo: dayjs('2024-04-28T07:21'),
  quantidadeMl: 10705,
};

export const sampleWithNewData: NewConsumoAgua = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
