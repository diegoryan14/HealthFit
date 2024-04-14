import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '1c030d7b-50ad-4702-9349-a00d6d51161e',
};

export const sampleWithPartialData: IAuthority = {
  name: 'c759e79e-7527-4a45-9d3f-2566396cf854',
};

export const sampleWithFullData: IAuthority = {
  name: 'af974397-dbc5-4e5a-91bc-b290e6eef07a',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
