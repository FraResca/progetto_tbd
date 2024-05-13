import '@testing-library/jest-dom';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import { createMemoryHistory } from 'history';
import React from 'react';
import { MemoryRouter } from 'react-router-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import RisultatoForm from '../components/viste/RisultatoForm';
import { createReferto, getReferto, updateReferto } from '../services/RefertoService';

jest.mock('../services/RefertoService');

test('renders form with empty fields', () => {
    const history = createMemoryHistory();
    history.push('/risultato/1');

    render(
        <Router history={history}>
          <RisultatoForm />
        </Router>
    );

    expect(screen.getByPlaceholderText('Inserisci referto')).toHaveValue('');
    expect(screen.getByPlaceholderText('Inserisci prescrizione')).toHaveValue('');
});

test('submits form with valid data', async () => {
    const risultato = {
        referto: 'Referto Test',
        prescr: 'Prescr Test',
        id_appuntamento: '1'
    };
  
    createReferto.mockResolvedValue({ data: risultato });
  
    render(
        <MemoryRouter initialEntries={['/risultatoForm/9/1']}>
            <RisultatoForm />
        </MemoryRouter>
    );

    createReferto.mockResolvedValue({ data: risultato });

    fireEvent.change(screen.getByPlaceholderText('Inserisci referto'), { target: { value: 'Referto Test' } });
    fireEvent.change(screen.getByPlaceholderText('Inserisci prescrizione'), { target: { value: 'Prescr Test' } });

    fireEvent.click(screen.getByText('Submit'));

    await waitFor(() => expect(createReferto).toHaveBeenCalled());
});

test('shows error messages for empty fields', async () => {
    const history = createMemoryHistory();
    history.push('/risultato/1');

    render(
        <Router history={history}>
          <RisultatoForm />
        </Router>
    );

    fireEvent.click(screen.getByText('Submit'));

    await screen.findByText('Inserire referto');
    await screen.findByText('Inserire prescrizione');
});