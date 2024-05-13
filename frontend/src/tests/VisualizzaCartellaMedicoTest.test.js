import { render, screen } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import VisualizzaCartellaMedico from '../components/liste/VisualizzaCartellaMedico';
import React from 'react';
import '@testing-library/jest-dom';

jest.mock('../services/RefertoService', () => ({
  listRefertiByPaziente: () => Promise.resolve({ data: [] }),
}));

describe('VisualizzaCartellaMedico', () => {
  test('renders without crashing', () => {
    render(<Router><VisualizzaCartellaMedico /></Router>);
  });

  test('renders correct text', async () => {
    render(<Router><VisualizzaCartellaMedico /></Router>);
    expect(screen.getByText('Lista referti')).toBeInTheDocument();
  });

  test('renders table headers', async () => {
    render(<Router><VisualizzaCartellaMedico /></Router>);
    expect(screen.getByText('Id')).toBeInTheDocument();
    expect(screen.getByText('Referto')).toBeInTheDocument();
    expect(screen.getByText('Prescrizione')).toBeInTheDocument();
    expect(screen.getByText('Appuntamento')).toBeInTheDocument();
  });
});