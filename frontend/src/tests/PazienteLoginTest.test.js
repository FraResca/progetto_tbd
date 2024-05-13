import { render, fireEvent, waitFor } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import PazienteLogin from '../components/login/PazienteLogin';
import React from 'react';
import '@testing-library/jest-dom';
import { pazienteByEmail } from '../adminServices/PazienteService';

jest.mock('../adminServices/PazienteService');

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
}));

test('PazienteLogin form validation and submission', async () => {
    const paziente = {
        id_utente: 1,
        nome: 'Mario',
        cognome: 'Rossi',
        email: 'paziente@example.com',
        password: 'paziente'
    };

    pazienteByEmail.mockResolvedValue({ data: paziente });

    const { getByLabelText, getByText, getAllByText } = render(
        <MemoryRouter>
            <PazienteLogin />
        </MemoryRouter>
    );

    const emailInput = getByLabelText('Email:');
    const passwordInput = getByLabelText('Password:');
    const submitButton = getByText('Submit');

    // Test form validation
    fireEvent.click(submitButton);
    const errorMessages = await waitFor(() => getAllByText('Campo obbligatorio'));
    expect(errorMessages).toHaveLength(2);
    
    // Test form submission with correct password
    fireEvent.change(emailInput, { target: { value: 'paziente@example.com' } });
    fireEvent.change(passwordInput, { target: { value: 'paziente' } });
    fireEvent.click(submitButton);

    await waitFor (() => expect(mockNavigator).toHaveBeenCalledWith('/appuntamentiPaziente/1'));
});

test('Get back to home', async () => {
    const { getByText } = render(
        <MemoryRouter>
            <PazienteLogin />
        </MemoryRouter>
    );

    const backButton = getByText('Go Back');
    fireEvent.click(backButton);
    expect(mockNavigator).toHaveBeenCalledWith('/');
});