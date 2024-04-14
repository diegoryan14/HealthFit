import dayjs from 'dayjs/esm';

import { IControleMedicamentos, NewControleMedicamentos } from './controle-medicamentos.model';

export const sampleWithRequiredData: IControleMedicamentos = {
  id: 1533,
};

export const sampleWithPartialData: IControleMedicamentos = {
  id: 6345,
  dosagem: 'eek negligible soon',
};

export const sampleWithFullData: IControleMedicamentos = {
  id: 8072,
  nomeMedicamento: 'venerated',
  dosagem: 'yippee never',
  horarioIngestao: dayjs('2024-04-13T04:54'),
};

export const sampleWithNewData: NewControleMedicamentos = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
