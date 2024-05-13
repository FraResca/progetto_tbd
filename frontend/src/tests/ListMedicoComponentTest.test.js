import '@testing-library/jest-dom';
import { render, screen, waitFor, act } from '@testing-library/react';
import { listMedici } from '../adminServices/MedicoService';
import { BrowserRouter as Router } from 'react-router-dom';
import ListMedicoComponent from '../components/admin/ListMedicoComponent';
import React from 'react';

jest.mock('../adminServices/MedicoService');

test('renders ListMedicoComponent without crashing', async () => {
  const medici = [
  { id_utente: 1, nome: 'Nome', cognome: 'Cognome', data_n: '1990-01-01', cf: 'rcsdaddas', email: 'nom.com@gmail.com', password: '1234', stipendio: 2000, specializ: 'Cardio' },
  { id_utente: 2, nome: 'Nome', cognome: 'Cognome', data_n: '1990-01-01', cf: 'rssdaddas', email: 'nom.com2@gmail.com', password: '1234', stipendio: 2000, specializ: 'Cardio' },
  { id_utente: 3, nome: 'Nome', cognome: 'Cognome', data_n: '1990-01-01', cf: 'rksdaddas', email: 'nom.com3@gmail.com', password: '1234', stipendio: 2000, specializ: 'Cardio' }];

  listMedici.mockResolvedValue({ data: medici });

  await act(async () => {
    render(
      <Router>
        <ListMedicoComponent />
      </Router>
    );
  });

  await waitFor(() => expect(listMedici).toHaveBeenCalled());
  const medicoItems = await screen.findAllByRole('row');
  expect(medicoItems).toHaveLength(medici.length + 1); // +1 for the header row
});

test('renders add new doctor button', async () => {
  await act(async () => {
    render(
      <Router>
        <ListMedicoComponent />
      </Router>
    );
  });

  await waitFor(() => {
    const buttonElement = screen.getByRole('button', { name: /Add Medico/i });
    expect(buttonElement).toBeInTheDocument();
  });
});

test('renders table of doctors', () => {
  render(
    <Router>
      <ListMedicoComponent />
    </Router>
  );
  
  const tableElement = screen.getByRole('table');
  expect(tableElement).toBeInTheDocument();
});

test('renders "Torna al Menu" button', () => {
  render(
    <Router>
      <ListMedicoComponent />
    </Router>
  );
  const buttonElement = screen.getByRole('button', { name: /Torna al Menu/i });
  expect(buttonElement).toBeInTheDocument();
});

test('renders correct number of rows in the table', async () => {
  
  await act(async () => {
    render(
      <Router>
        <ListMedicoComponent />
      </Router>
    );
  });
  
  

  // Wait for the rows to be in the document
  const rowElements = await screen.findAllByRole('row');

  // We add 1 to the length check because the table has a header row
  await waitFor(() => {
    expect(rowElements).toHaveLength(4); // 2 rows for the data, 1 row for the header
  });
});