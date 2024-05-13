import { render, fireEvent, waitFor } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import HrLogin from '../components/login/HrLogin';
import React from 'react';
import '@testing-library/jest-dom';

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
}));

test('HrLogin form validation and submission', async () => {
    const { getByLabelText, getByText } = render(
        <MemoryRouter>
            <HrLogin />
        </MemoryRouter>
    );

    const passwordInput = getByLabelText('Password:');
    const submitButton = getByText('Submit');

    // Test form validation
    fireEvent.click(submitButton);
    await waitFor(() => expect(getByText('Campo obbligatorio')).toBeInTheDocument());

    // Test form submission with incorrect password
    fireEvent.change(passwordInput, { target: { value: 'admin' } });
    fireEvent.click(submitButton);
    await waitFor(() => expect(getByText('Campo obbligatorio')).toBeInTheDocument());

    // Test form submission with correct password
    fireEvent.change(passwordInput, { target: { value: 'hr' } });
    fireEvent.click(submitButton);
    expect(mockNavigator).toHaveBeenCalledWith('/AppuntamentiHr');
});

test('Get back to home', async () => {
    const { getByText } = render(
        <MemoryRouter>
            <HrLogin />
        </MemoryRouter>
    );

    const backButton = getByText('Go Back');
    fireEvent.click(backButton);
    expect(mockNavigator).toHaveBeenCalledWith('/');
});