import { render, fireEvent, waitFor, screen, act } from '@testing-library/react'
import ProfiloMedico from '../components/viste/ProfiloMedico'
import { createMedico, getMedico, updateMedico } from '../adminServices/MedicoService'
import { MemoryRouter, Route, Routes } from 'react-router-dom'
import React from 'react'
import '@testing-library/jest-dom'

jest.mock('../adminServices/MedicoService')

describe('ProfiloMedico', () => {
  test('renders form with empty fields when no id_medico is provided', async () => {
    render(<ProfiloMedico />, { wrapper: MemoryRouter })

    expect(screen.getByLabelText('First Name:')).toHaveValue('')
    expect(screen.getByLabelText('Last Name:')).toHaveValue('')
    // ...assert the rest of the fields...
  })

  test('fetches and displays data when id_medico is provided', async () => {
    getMedico.mockResolvedValueOnce({
      data: {
        nome: 'Test',
        cognome: 'User',
        data_n: '1999-01-01',
        cf: 'TSTUSR99A01Z999A',
        email: 'test.user@gmail.com',
        password: 'password',
        stipendio: 1000,
        specializ: 'specializzazione',
      }
    })

    render(
      <MemoryRouter initialEntries={['/medico/1']}>
        <Routes>
          <Route path="/medico/:id_medico" element={<ProfiloMedico />} />
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
    expect(screen.getByLabelText('Stipendio:')).toHaveValue(1000)
    expect(screen.getByLabelText('Specializzazione:')).toHaveValue('specializzazione')
  })

  test('calls createMedico when form is submitted with no id_medico', async () => {
    createMedico.mockResolvedValueOnce({
      data: {
        nome: 'Test',
        cognome: 'User',
        data_n: '1999-01-01',
        cf: 'TSTUSR99A01Z999A',
        email: 'test.user@gmail.com',
        password: 'password',
        stipendio: 1000,
        specializ: 'specializzazione',
      }
    })


    await act(async () => {
      render(
        <MemoryRouter initialEntries={['/add-medico']}>
          <Routes>
            <Route path="/add-medico" element={<ProfiloMedico />} />
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
    fireEvent.change(screen.getByPlaceholderText('Inserire stipendio'), { target: { value: 1000 }} );
    fireEvent.change(screen.getByPlaceholderText('Inserire specializzazione'), { target: { value: 'specializzazione' } });

    
    fireEvent.click(screen.getByText('Submit'))

    await waitFor(() => expect(createMedico).toHaveBeenCalled())
  })

  test('calls updateMedico when form is submitted with id_medico', async () => {
    getMedico.mockResolvedValueOnce({
        data: {
          nome: 'Test',
          cognome: 'User',
          data_n: '1999-01-01',
          cf: 'TSTUSR99A01Z999A',
          email: 'test.user@gmail.com',
          password: 'password',
          stipendio: 1000,
          specializ: 'specializzazione',
        }
    })
    updateMedico.mockResolvedValueOnce({})

    await act(async () => {
      render(
        <MemoryRouter initialEntries={['/edit-medico/1']}>
          <Routes>
            <Route path="/edit-medico/:id_medico" element={<ProfiloMedico />} />
          </Routes>
        </MemoryRouter>
      );
    });

    fireEvent.click(screen.getByText('Submit'))

    await waitFor(() => expect(updateMedico).toHaveBeenCalled())
  })
})