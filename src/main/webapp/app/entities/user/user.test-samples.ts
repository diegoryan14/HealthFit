import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 31960,
  login: '7ZqKZ',
};

export const sampleWithPartialData: IUser = {
  id: 20231,
  login: '20N9',
};

export const sampleWithFullData: IUser = {
  id: 25575,
  login: 'if65l@6Hw1\\4jmmZz',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
