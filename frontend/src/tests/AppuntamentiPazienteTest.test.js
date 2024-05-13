import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import { act } from 'react-dom/test-utils';
import AppuntamentiPaziente from '../components/liste/AppuntamentiPaziente';
import { listAppuntamentiPaziente, listRefertiByAppuntamento } from '../services/AppuntamentiService';
import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import '@testing-library/jest-dom';

jest.mock('../services/AppuntamentiService');

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
  useParams: () => ({ idPaziente: 2 }),
}));

jest.mock('../services/RefertoService', () => ({
    listRefertiByAppuntamento: jest.fn(),
}));

test('renders AppuntamentiPaziente and fetches appuntamenti', async () => {
  const appuntamenti = [
    { id_app: 1, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 1 },
    { id_app: 2, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 2 },
    { id_app: 3, id_paziente: 1, id_medico: 1, id_visita: 1, id_slot: 3 }
  ];

  listAppuntamentiPaziente.mockResolvedValue({ data: appuntamenti });

  const setState = jest.fn();
  const useStateSpy = jest.spyOn(React, 'useState');
  useStateSpy.mockImplementation((init) => [init, setState]);

  await act(async () => {
    render(
      <Router>
        <AppuntamentiPaziente />
      </Router>
    );
  });

  await act(async () => {
    await waitFor(() => expect(listAppuntamentiPaziente).toHaveBeenCalled());
  });
  
  const appuntamentoItems = await screen.findAllByRole('cell');

  expect(appuntamentoItems).toHaveLength(6 * appuntamenti.length);

  useStateSpy.mockRestore();
});

test('navigates to visualizzaProfilo', async () => {
  await act(async () => {
    render(
      <Router>
        <AppuntamentiPaziente />
      </Router>
    );
  });

  const visualizzaProfiloButton = screen.getByText(/Profilo/i);
  fireEvent.click(visualizzaProfiloButton);

  expect(mockNavigator).toHaveBeenCalledWith('/edit-paziente/2');
});