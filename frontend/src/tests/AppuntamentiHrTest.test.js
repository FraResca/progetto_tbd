// src/tests/AppuntamentiHr.test.js
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import { act } from 'react-dom/test-utils';
import AppuntamentiHr from '../components/liste/AppuntamentiHr';
import { listAppuntamenti, deleteAppuntamento } from '../services/AppuntamentiService';
import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import '@testing-library/jest-dom';

jest.mock('../services/AppuntamentiService');

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
}));

test('renders AppuntamentiHr and fetches appuntamenti', async () => {
  const appuntamenti = [
    { id_app: 1, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 1 },
    { id_app: 2, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 2 },
    { id_app: 3, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 3 }
  ];

  listAppuntamenti.mockResolvedValue({ data: appuntamenti });

  const setState = jest.fn();
  const useStateSpy = jest.spyOn(React, 'useState');
  useStateSpy.mockImplementation((init) => [init, setState]);

  await act(async () => {
    render(
      <Router>
        <AppuntamentiHr />
      </Router>
    );
  });

  await act(async () => {
    await waitFor(() => expect(listAppuntamenti).toHaveBeenCalled());
  });
  
  const appuntamentoItems = await screen.findAllByRole('cell');

  expect(appuntamentoItems).toHaveLength(7 * appuntamenti.length);

  useStateSpy.mockRestore();
});

test('deletes an appuntamento', async () => {
  const appuntamenti = [{ id_app: 1, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 1 },
                        { id_app: 2, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 2 },
                        { id_app: 3, pagato: false, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 3 }];

  listAppuntamenti.mockResolvedValue({ data: appuntamenti });
  deleteAppuntamento.mockResolvedValue();

  await act(async () => {
    render(
      <Router>
        <AppuntamentiHr />
      </Router>
    );
  });

  // Wait for the Delete button to appear in the document
  const deleteButtons = await screen.findAllByText(/Delete/i);
  
  expect(deleteButtons).toHaveLength(appuntamenti.length);
  
  await act(async () => {
    fireEvent.click(deleteButtons[0]);
  });
});

test('navigates to add new appuntamento', async () => {
  await act(async () => {
    render(
      <Router>
        <AppuntamentiHr />
      </Router>
    );
  });

  const addButton = screen.getByText(/Aggiungi appuntamento/i);
  fireEvent.click(addButton);

  expect(mockNavigator).toHaveBeenCalledWith('/add-appuntamento');
});

test('navigates to the home', async () => {
  await act(async () => {
    render(
      <Router>
        <AppuntamentiHr />
      </Router>
    );
  });

  const homeButton = screen.getByText(/Torna alla home/i);
  fireEvent.click(homeButton);

  expect(mockNavigator).toHaveBeenCalledWith('/');
});
