import '@testing-library/jest-dom';
import { render, screen, waitFor, act } from '@testing-library/react';
import { listPazienti } from '../adminServices/PazienteService';
import { BrowserRouter as Router } from 'react-router-dom';
import ListPazienteComponent from '../components/admin/ListPazienteComponent';
import React from 'react';

jest.mock('../adminServices/PazienteService', () => ({
  listPazienti: jest.fn().mockResolvedValue({ data: [
    { id_utente: 1, nome: 'Nome', cognome: 'Cognome', data_n: '1990-01-01', cf: 'rcsdaddas', email: 'nom.com@gmail.com', password: '1234' },
    { id_utente: 2, nome: 'Nome', cognome: 'Cognome', data_n: '1990-01-01', cf: 'rssdaddas', email: 'nom.com2@gmail.com', password: '1234' }
  ]}),
}));

test('renders ListPazienteComponent without crashing', async () => {
  render(
    <Router>
      <ListPazienteComponent />
    </Router>
  );

  await waitFor(() => {
    const linkElement = screen.getByText(/Lista di Pazienti/i);
    expect(linkElement).toBeInTheDocument();
  });
});

test('renders add new patient button', async () => {
  render(
    <Router>
      <ListPazienteComponent />
    </Router>
  );

  await waitFor(() => {
    const buttonElement = screen.getByRole('button', { name: /Add Paziente/i });
    expect(buttonElement).toBeInTheDocument();
  });
});

test('renders table of patients', () => {
  render(
    <Router>
      <ListPazienteComponent />
    </Router>
  );
  const tableElement = screen.getByRole('table');
  expect(tableElement).toBeInTheDocument();
});

test('renders "Torna al Menu" button', () => {
  render(
    <Router>
      <ListPazienteComponent />
    </Router>
  );
  const buttonElement = screen.getByRole('button', { name: /Torna al Menu/i });
  expect(buttonElement).toBeInTheDocument();
});

test('renders correct number of rows in the table', async () => {
  await act(async () => {
    render(
      <Router>
        <ListPazienteComponent />
      </Router>
    );
  });

  // Wait for the rows to be in the document
  const rowElements = await screen.findAllByRole('row');

  // We add 1 to the length check because the table has a header row
  await waitFor(() => {
    expect(rowElements).toHaveLength(3); // 2 rows for the data, 1 row for the header
  });
});