import dayjs from 'dayjs/esm';

import { IAtividadeFisica, NewAtividadeFisica } from './atividade-fisica.model';

export const sampleWithRequiredData: IAtividadeFisica = {
  id: 11909,
};

export const sampleWithPartialData: IAtividadeFisica = {
  id: 17168,
  dataHorario: dayjs('2024-04-13T22:27'),
  passosCalorias: 28623,
};

export const sampleWithFullData: IAtividadeFisica = {
  id: 14412,
  tipoAtividade: 'FUTEBOL',
  dataHorario: dayjs('2024-04-14T02:05'),
  duracao: 29730,
  passosCalorias: 16266,
};

export const sampleWithNewData: NewAtividadeFisica = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
