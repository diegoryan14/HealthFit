import dayjs from 'dayjs/esm';

import { IQualidadeSono, NewQualidadeSono } from './qualidade-sono.model';

export const sampleWithRequiredData: IQualidadeSono = {
  id: 9721,
};

export const sampleWithPartialData: IQualidadeSono = {
  id: 20432,
  horasSono: 5082,
};

export const sampleWithFullData: IQualidadeSono = {
  id: 9053,
  data: dayjs('2024-04-13T08:06'),
  horasSono: 16601,
};

export const sampleWithNewData: NewQualidadeSono = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
