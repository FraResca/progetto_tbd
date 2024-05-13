import React from 'react';
import { render, fireEvent, waitFor, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import ElencoSlot from '../components/liste/ElencoSlot';
import { listFreeSlots, updateSlot, getSlot } from '../services/SlotService';
import { createAppuntamento } from "../services/AppuntamentiService";

jest.mock('../services/SlotService');
jest.mock('../services/AppuntamentiService');

describe('ElencoSlot', () => {
  beforeEach(() => {
    listFreeSlots.mockResolvedValue({ data: [{ id_slot: '1', dataSlot: '2022-01-01', oraSlot: '10:00' }] });
    getSlot.mockResolvedValue({ data: { id_slot: '1', dataSlot: '2022-01-01', oraSlot: '10:00', occupato: false } });
    updateSlot.mockResolvedValue({});
    createAppuntamento.mockResolvedValue({});
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  it('renders without crashing', () => {
    render(<Router><ElencoSlot /></Router>);
    expect(screen.getByText('Scegli uno fra gli slot disponibili')).toBeInTheDocument();
  });

  it('displays slots', async () => {
    render(<Router><ElencoSlot /></Router>);
    await waitFor(() => expect(screen.getByText('1')).toBeInTheDocument());
    expect(screen.getByText('2022-01-01')).toBeInTheDocument();
    expect(screen.getByText('10:00')).toBeInTheDocument();
  });
});