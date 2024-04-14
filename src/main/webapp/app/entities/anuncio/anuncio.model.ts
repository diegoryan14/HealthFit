import dayjs from 'dayjs/esm';

export interface IAnuncio {
  id: number;
  titulo?: string | null;
  descricao?: string | null;
  dataPublicacao?: dayjs.Dayjs | null;
  preco?: number | null;
}

export type NewAnuncio = Omit<IAnuncio, 'id'> & { id: null };
