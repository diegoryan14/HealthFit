import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IMetasSaude, NewMetasSaude } from '../metas-saude.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IMetasSaude for edit and NewMetasSaudeFormGroupInput for create.
 */
type MetasSaudeFormGroupInput = IMetasSaude | PartialWithRequiredKeyOf<NewMetasSaude>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends IMetasSaude | NewMetasSaude> = Omit<T, 'dataLimite'> & {
  dataLimite?: string | null;
};

type MetasSaudeFormRawValue = FormValueOf<IMetasSaude>;

type NewMetasSaudeFormRawValue = FormValueOf<NewMetasSaude>;

type MetasSaudeFormDefaults = Pick<NewMetasSaude, 'id' | 'dataLimite'>;

type MetasSaudeFormGroupContent = {
  id: FormControl<MetasSaudeFormRawValue['id'] | NewMetasSaude['id']>;
  tipoMeta: FormControl<MetasSaudeFormRawValue['tipoMeta']>;
  valorMeta: FormControl<MetasSaudeFormRawValue['valorMeta']>;
  dataLimite: FormControl<MetasSaudeFormRawValue['dataLimite']>;
  internalUser: FormControl<MetasSaudeFormRawValue['internalUser']>;
};

export type MetasSaudeFormGroup = FormGroup<MetasSaudeFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class MetasSaudeFormService {
  createMetasSaudeFormGroup(metasSaude: MetasSaudeFormGroupInput = { id: null }): MetasSaudeFormGroup {
    const metasSaudeRawValue = this.convertMetasSaudeToMetasSaudeRawValue({
      ...this.getFormDefaults(),
      ...metasSaude,
    });
    return new FormGroup<MetasSaudeFormGroupContent>({
      id: new FormControl(
        { value: metasSaudeRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        },
      ),
      tipoMeta: new FormControl(metasSaudeRawValue.tipoMeta),
      valorMeta: new FormControl(metasSaudeRawValue.valorMeta),
      dataLimite: new FormControl(metasSaudeRawValue.dataLimite),
      internalUser: new FormControl(metasSaudeRawValue.internalUser),
    });
  }

  getMetasSaude(form: MetasSaudeFormGroup): IMetasSaude | NewMetasSaude {
    return this.convertMetasSaudeRawValueToMetasSaude(form.getRawValue() as MetasSaudeFormRawValue | NewMetasSaudeFormRawValue);
  }

  resetForm(form: MetasSaudeFormGroup, metasSaude: MetasSaudeFormGroupInput): void {
    const metasSaudeRawValue = this.convertMetasSaudeToMetasSaudeRawValue({ ...this.getFormDefaults(), ...metasSaude });
    form.reset(
      {
        ...metasSaudeRawValue,
        id: { value: metasSaudeRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */,
    );
  }

  private getFormDefaults(): MetasSaudeFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      dataLimite: currentTime,
    };
  }

  private convertMetasSaudeRawValueToMetasSaude(
    rawMetasSaude: MetasSaudeFormRawValue | NewMetasSaudeFormRawValue,
  ): IMetasSaude | NewMetasSaude {
    return {
      ...rawMetasSaude,
      dataLimite: dayjs(rawMetasSaude.dataLimite, DATE_TIME_FORMAT),
    };
  }

  private convertMetasSaudeToMetasSaudeRawValue(
    metasSaude: IMetasSaude | (Partial<NewMetasSaude> & MetasSaudeFormDefaults),
  ): MetasSaudeFormRawValue | PartialWithRequiredKeyOf<NewMetasSaudeFormRawValue> {
    return {
      ...metasSaude,
      dataLimite: metasSaude.dataLimite ? metasSaude.dataLimite.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
