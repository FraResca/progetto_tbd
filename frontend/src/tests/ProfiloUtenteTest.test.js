import { render, fireEvent, waitFor, screen, act } from '@testing-library/react'
import ProfiloUtente from '../components/viste/ProfiloUtente'
import { createPaziente, getPaziente, updatePaziente } from '../adminServices/PazienteService'
import { MemoryRouter, Route, Routes } from 'react-router-dom'
import React from 'react'
import '@testing-library/jest-dom'

jest.mock('../adminServices/PazienteService')

describe('ProfiloUtente', () => {
  test('renders form with empty fields when no id_paziente is provided', async () => {
    render(<ProfiloUtente />, { wrapper: MemoryRouter })

    expect(screen.getByLabelText('First Name:')).toHaveValue('')
    expect(screen.getByLabelText('Last Name:')).toHaveValue('')
    expect(screen.getByLabelText('Date of Birth:')).toHaveValue('')
    expect(screen.getByLabelText('Codice Fiscale:')).toHaveValue('')
    expect(screen.getByLabelText('Email:')).toHaveValue('')
    expect(screen.getByLabelText('Password:')).toHaveValue('')
  })

  test('fetches and displays data when id_paziente is provided', async () => {
    getPaziente.mockResolvedValueOnce({
      data: {
        nome: 'Test',
        cognome: 'User',
        data_n: '1999-01-01',
        cf: 'TSTUSR99A01Z999A',
        email: 'test.user@gmail.com',
        password: 'password',
      }
    })

    render(
      <MemoryRouter initialEntries={['/paziente/1']}>
        <Routes>
          <Route path="/paziente/:id_paziente" element={<ProfiloUtente />} />
        </Routes>
      </MemoryRouter>
    )

    await waitFor(() => screen.getByLabelText('First Name:'))

    expect(screen.getByLabelText('First Name:')).toHaveValue('Test')
    expect(screen.getByLabelText('Last Name:')).toHaveValue('User')
    expect(screen.getByLabelText('Date of Birth:')).toHaveValue('1999-01-01')
    expect(screen.getByLabelText('Codice Fiscale:')).toHaveValue('TSTUSR99A01Z999A')
    expect(screen.getByLabelText('Email:')).toHaveValue('test.user@gmail.com')
    expect(screen.getByLabelText('Password:')).toHaveValue('password')
  })

  test('calls createPaziente when form is submitted with no id_paziente', async () => {
    createPaziente.mockResolvedValueOnce({
      data: {
        nome: 'Test',
        cognome: 'User',
        data_n: '1999-01-01',
        cf: 'TSTUSR99A01Z999A',
        email: 'test.user@gmail.com',
        password: 'password',
      }
    })


    await act(async () => {
      render(
        <MemoryRouter initialEntries={['/add-paziente']}>
          <Routes>
            <Route path="/add-paziente" element={<ProfiloUtente />} />
          </Routes>
        </MemoryRouter>
      );
    });

    fireEvent.change(screen.getByPlaceholderText('Inserire nome'), { target: { value: 'Test' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire cognome'), { target: { value: 'User' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire data di nascita'), { target: { value: '1999-01-01' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire codice fiscale'), { target: { value: 'TSTUSR99A01Z999A' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire email'), { target: { value: 'test.user@gmail.com' } });
    fireEvent.change(screen.getByPlaceholderText('Inserire password'), { target: { value: 'password' } });
    
    fireEvent.click(screen.getByText('Submit'))

    await waitFor(() => expect(createPaziente).toHaveBeenCalled())
  })

  test('calls updatePaziente when form is submitted with id_paziente', async () => {
    getPaziente.mockResolvedValueOnce({
        data: {
          nome: 'Test',
          cognome: 'User',
          data_n: '1999-01-01',
          cf: 'TSTUSR99A01Z999A',
          email: 'test.user@gmail.com',
          password: 'password',
        }
    })
    updatePaziente.mockResolvedValueOnce({})

    await act(async () => {
      render(
        <MemoryRouter initialEntries={['/edit-paziente/1']}>
          <Routes>
            <Route path="/edit-paziente/:id_paziente" element={<ProfiloUtente />} />
          </Routes>
        </MemoryRouter>
      );
    });

    fireEvent.click(screen.getByText('Submit'))

    await waitFor(() => expect(updatePaziente).toHaveBeenCalled())
  })
})