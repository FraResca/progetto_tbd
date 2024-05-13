import { render, fireEvent, waitFor } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import AdminLogin from '../components/login/AdminLogin';
import React from 'react';
import '@testing-library/jest-dom';

const mockNavigator = jest.fn();

jest.mock('react-router-dom', () => ({
  ...jest.requireActual('react-router-dom'),
  useNavigate: () => mockNavigator,
}));

test('AdminLogin form validation and submission', async () => {
    const { getByLabelText, getByText } = render(
        <MemoryRouter>
            <AdminLogin />
        </MemoryRouter>
    );

    const passwordInput = getByLabelText('Password:');
    const submitButton = getByText('Submit');

    // Test form validation
    fireEvent.click(submitButton);
    await waitFor(() => expect(getByText('Campo obbligatorio')).toBeInTheDocument());

    // Test form submission
    fireEvent.change(passwordInput, { target: { value: 'admin' } });
    fireEvent.click(submitButton);
    expect(mockNavigator).toHaveBeenCalledWith('/MenuComponent');
});

test('Get back to home', async () => {
    const { getByText } = render(
        <MemoryRouter>
            <AdminLogin />
        </MemoryRouter>
    );

    const backButton = getByText('Go Back');
    fireEvent.click(backButton);
    expect(mockNavigator).toHaveBeenCalledWith('/');
});