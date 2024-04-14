import dayjs from 'dayjs/esm';

import { IAnuncio, NewAnuncio } from './anuncio.model';

export const sampleWithRequiredData: IAnuncio = {
  id: 26381,
};

export const sampleWithPartialData: IAnuncio = {
  id: 2940,
  titulo: 'dimpled partner so',
  descricao: 'warm-up',
  dataPublicacao: dayjs('2024-04-13T09:16'),
  preco: 11967.52,
};

export const sampleWithFullData: IAnuncio = {
  id: 26353,
  titulo: 'forceful',
  descricao: 'striking provided',
  dataPublicacao: dayjs('2024-04-13T16:11'),
  preco: 25991.18,
};

export const sampleWithNewData: NewAnuncio = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
