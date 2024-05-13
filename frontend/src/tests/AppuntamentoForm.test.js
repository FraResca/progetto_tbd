import '@testing-library/jest-dom';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import { createMemoryHistory } from 'history';
import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import AppuntamentoForm from '../components/viste/AppuntamentoForm';
import { createAppuntamento, getAppuntamento, updateAppuntamento } from '../services/AppuntamentiService';

jest.mock('../services/AppuntamentiService');

test('renders form with empty fields', () => {
    const history = createMemoryHistory();
    history.push('/appuntamento/1');

    render(
        <Router history={history}>
          <AppuntamentoForm />
        </Router>
    );

    expect(screen.getByPlaceholderText('Inserire paziente')).toHaveValue('');
    expect(screen.getByPlaceholderText('Inserire medico')).toHaveValue('');
    expect(screen.getByPlaceholderText('Inserire visita')).toHaveValue('');
    expect(screen.getByPlaceholderText('Inserire slot')).toHaveValue('');
});

test('submits form with valid data', async () => {
    const history = createMemoryHistory();
    history.push('/appuntamento/1');


    render(
        <Router history={history}>
          <AppuntamentoForm />
        </Router>
    );

    const appuntamento = {
      pagato: false,
      id_paziente: '1',
      id_medico: '1',
      id_visita: '1',
      id_slot: '1'
    };

    createAppuntamento.mockResolvedValue({ data: appuntamento });

    fireEvent.change(screen.getByPlaceholderText('Inserire paziente'), { target: { value: '1' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire medico'), { target: { value: '1' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire visita'), { target: { value: '1' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire slot'), { target: { value: '1' } });

    fireEvent.click(screen.getByText('Submit'));

    await waitFor(() => expect(createAppuntamento).toHaveBeenCalledWith(appuntamento));
});

test('shows error messages for empty fields', async () => {
    const history = createMemoryHistory();
    history.push('/appuntamento/1');


    render(
        <Router history={history}>
          <AppuntamentoForm />
        </Router>
    );

    fireEvent.click(screen.getByText('Submit'));

    await screen.findByText('Inserire paziente');
    await screen.findByText('Inserire medico');
    await screen.findByText('Inserire visita');
    await screen.findByText('Inserire slot');
});