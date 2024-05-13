import { render, fireEvent, waitFor } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import MedicoLogin from '../components/login/MedicoLogin';
import React from 'react';
import '@testing-library/jest-dom';
import { medicoByEmail } from '../adminServices/MedicoService';

jest.mock('../adminServices/MedicoService');

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
}));

test('MedicoLogin form validation and submission', async () => {
    const medico = {
        id_utente: 1,
        nome: 'Mario',
        cognome: 'Rossi',
        email: 'medico@example.com',
        password: 'medico'
    };

    medicoByEmail.mockResolvedValue({ data: medico });

    const { getByLabelText, getByText, getAllByText } = render(
        <MemoryRouter>
            <MedicoLogin />
        </MemoryRouter>
    );

    const emailInput = getByLabelText('Email:');
    const passwordInput = getByLabelText('Password:');
    const submitButton = getByText('Submit');

    // Test form validation
    fireEvent.click(submitButton);
    const errorMessages = await waitFor(() => getAllByText('Campo obbligatorio'));
    expect(errorMessages).toHaveLength(2);
    
    // Test form submission with incorrect password
    fireEvent.change(emailInput, { target: { value: 'medico@example.com' } });
    fireEvent.change(passwordInput, { target: { value: 'medico' } });
    fireEvent.click(submitButton);

    await waitFor (() => expect(mockNavigator).toHaveBeenCalledWith('/appuntamentiMedico/1'));
});

test('Get back to home', async () => {
    const { getByText } = render(
        <MemoryRouter>
            <MedicoLogin />
        </MemoryRouter>
    );

    const backButton = getByText('Go Back');
    fireEvent.click(backButton);
    expect(mockNavigator).toHaveBeenCalledWith('/');
});