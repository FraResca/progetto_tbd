import { render, screen } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import VisualizzaCartella from '../components/liste/VisualizzaCartella';
import React from 'react';
import '@testing-library/jest-dom';

jest.mock('../services/RefertoService', () => ({
  listRefertiByPaziente: () => Promise.resolve({ data: [] }),
}));

describe('VisualizzaCartella', () => {
  test('renders without crashing', () => {
    render(<Router><VisualizzaCartella /></Router>);
  });

  test('renders correct text', async () => {
    render(<Router><VisualizzaCartella /></Router>);
    expect(screen.getByText('Lista referti')).toBeInTheDocument();
  });

  test('renders table headers', async () => {
    render(<Router><VisualizzaCartella /></Router>);
    expect(screen.getByText('Id')).toBeInTheDocument();
    expect(screen.getByText('Referto')).toBeInTheDocument();
    expect(screen.getByText('Prescrizione')).toBeInTheDocument();
    expect(screen.getByText('Appuntamento')).toBeInTheDocument();
  });
});