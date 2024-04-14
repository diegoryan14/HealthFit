import dayjs from 'dayjs/esm';

import { IMetasSaude, NewMetasSaude } from './metas-saude.model';

export const sampleWithRequiredData: IMetasSaude = {
  id: 16010,
};

export const sampleWithPartialData: IMetasSaude = {
  id: 1871,
};

export const sampleWithFullData: IMetasSaude = {
  id: 8026,
  tipoMeta: 'OUTRO',
  valorMeta: 1775,
  dataLimite: dayjs('2024-04-13T14:01'),
};

export const sampleWithNewData: NewMetasSaude = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
