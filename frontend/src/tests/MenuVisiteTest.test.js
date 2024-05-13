import { render, screen } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import MenuVisite from '../components/liste/MenuVisite';
import React from 'react';
import '@testing-library/jest-dom';

jest.mock('../services/VisiteService', () => ({
  listVisite: () => Promise.resolve({ data: [] }),
}));

jest.mock('../adminServices/MedicoService', () => ({
  listMedici: () => Promise.resolve({ data: [] }),
}));

describe('MenuVisite', () => {
  test('renders without crashing', () => {
    render(<Router><MenuVisite /></Router>);
  });

  test('renders correct text', async () => {
    render(<Router><MenuVisite /></Router>);
    expect(screen.getByText('Prenota qui le tue visite')).toBeInTheDocument();
    expect(screen.getByText('tutte le visite vengono svolte da personale specializzato pronto a venire in contro ad ogni esigenza del cliente')).toBeInTheDocument();
  });

  test('renders table headers', async () => {
    render(<Router><MenuVisite /></Router>);
    expect(screen.getByText('Tipo')).toBeInTheDocument();
    expect(screen.getByText('Descrizione')).toBeInTheDocument();
    expect(screen.getByText('Prezzo')).toBeInTheDocument();
    expect(screen.getByText('Medico')).toBeInTheDocument();
    expect(screen.getByText('Actions')).toBeInTheDocument();
  });
});
