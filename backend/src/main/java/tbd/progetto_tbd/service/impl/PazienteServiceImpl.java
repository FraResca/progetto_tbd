package tbd.progetto_tbd.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbd.progetto_tbd.dto.PazienteDto;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.PazienteMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.service.PazienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PazienteServiceImpl implements PazienteService {
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;

    @Override
    public PazienteDto createPaziente(PazienteDto pazienteDto) {
        Paziente paziente = PazienteMapper.mapToPaziente(pazienteDto, appuntamentoRepository);
        Paziente savedPaziente = pazienteRepository.save(paziente);
        return PazienteMapper.mapToPazienteDto(savedPaziente);
    }
    
    @Override
    public PazienteDto getPazienteById(Long id_paziente){
        Paziente paziente = pazienteRepository.findById(id_paziente)
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per l'id dato : " + id_paziente));
            return PazienteMapper.mapToPazienteDto(paziente);
    }

    @Override
    public List<PazienteDto> getAllPazienti(){
        List<Paziente> pazienti = pazienteRepository.findAll();
        return pazienti.stream().map((paziente) -> PazienteMapper.mapToPazienteDto(paziente))
            .collect(Collectors.toList());
    }

    @Override
    public PazienteDto updatePaziente(Long id_paziente, PazienteDto updatedPaziente){
        Paziente paziente = pazienteRepository.findById(id_paziente)
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per l'id dato : " + id_paziente));
        paziente.setNome(updatedPaziente.getNome());
        paziente.setCognome(updatedPaziente.getCognome());
        paziente.setData_n(updatedPaziente.getData_n());
        paziente.setCf(updatedPaziente.getCf());
        paziente.setEmail(updatedPaziente.getEmail());
        paziente.setPassword(updatedPaziente.getPassword());

        Paziente updatedPazienteObj = pazienteRepository.save(paziente);

        return PazienteMapper.mapToPazienteDto(updatedPazienteObj);
    }

    @Override
    public void deletePaziente(Long id_paziente){
        pazienteRepository.findById(id_paziente)
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per l'id dato : " + id_paziente));
        pazienteRepository.deleteById(id_paziente);
    }

    @Override
    public PazienteDto getPazienteByEmail(String email){
        Paziente paziente = pazienteRepository.findByEmail(email);
        return PazienteMapper.mapToPazienteDto(paziente);
    }
}
