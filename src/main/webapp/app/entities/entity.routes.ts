import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'authority',
    data: { pageTitle: 'healthFitApp.adminAuthority.home.title' },
    loadChildren: () => import('./admin/authority/authority.routes'),
  },
  {
    path: 'usuario',
    data: { pageTitle: 'healthFitApp.usuario.home.title' },
    loadChildren: () => import('./usuario/usuario.routes'),
  },
  {
    path: 'atividade-fisica',
    data: { pageTitle: 'healthFitApp.atividadeFisica.home.title' },
    loadChildren: () => import('./atividade-fisica/atividade-fisica.routes'),
  },
  {
    path: 'dieta',
    data: { pageTitle: 'healthFitApp.dieta.home.title' },
    loadChildren: () => import('./dieta/dieta.routes'),
  },
  {
    path: 'qualidade-sono',
    data: { pageTitle: 'healthFitApp.qualidadeSono.home.title' },
    loadChildren: () => import('./qualidade-sono/qualidade-sono.routes'),
  },
  {
    path: 'controle-medicamentos',
    data: { pageTitle: 'healthFitApp.controleMedicamentos.home.title' },
    loadChildren: () => import('./controle-medicamentos/controle-medicamentos.routes'),
  },
  {
    path: 'metas-saude',
    data: { pageTitle: 'healthFitApp.metasSaude.home.title' },
    loadChildren: () => import('./metas-saude/metas-saude.routes'),
  },
  {
    path: 'anuncio',
    data: { pageTitle: 'healthFitApp.anuncio.home.title' },
    loadChildren: () => import('./anuncio/anuncio.routes'),
  },
  {
    path: 'consulta-especialista',
    data: { pageTitle: 'healthFitApp.consultaEspecialista.home.title' },
    loadChildren: () => import('./consulta-especialista/consulta-especialista.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
