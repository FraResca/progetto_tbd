package tbd.progetto_tbd.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.AppuntamentoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.repository.VisitaRepository;
import tbd.progetto_tbd.service.AppuntamentoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AppuntamentoServiceImpl implements AppuntamentoService {
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private RisultatoRepository risultatoRepository;
    @Autowired
    private VisitaRepository visitaRepository;
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto) {
        Appuntamento appuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        appuntamento.setPaziente(pazienteRepository.findById(appuntamentoDto.getId_paziente()).get());        
        appuntamento.setMedico(medicoRepository.findById(appuntamentoDto.getId_medico()).get());
        appuntamento.setVisita(visitaRepository.findById(appuntamentoDto.getId_visita()).get());
        appuntamento.setSlot(slotRepository.findById(appuntamentoDto.getId_slot()).get());
        Appuntamento savedAppuntamento = appuntamentoRepository.save(appuntamento);
        return AppuntamentoMapper.mapToAppuntamentoDto(savedAppuntamento);
    }
    
    @Override
    public AppuntamentoDto getAppuntamentoById(Long id_appuntamento){
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
            return AppuntamentoMapper.mapToAppuntamentoDto(appuntamento);
    }

    @Override
    public List<AppuntamentoDto> getAllAppuntamenti(){
        List<Appuntamento> appuntamenti = appuntamentoRepository.findAll();
        return appuntamenti.stream().map((appuntamento) -> AppuntamentoMapper.mapToAppuntamentoDto(appuntamento))
            .collect(Collectors.toList());
    }

    @Override
    public AppuntamentoDto updateAppuntamento(Long id_appuntamento, AppuntamentoDto updatedAppuntamento){
        Appuntamento appuntamento = appuntamentoRepository.findById(id_appuntamento).get();
        appuntamento.setPagato(updatedAppuntamento.getPagato());
        appuntamento.setPaziente(pazienteRepository.findById(updatedAppuntamento.getId_paziente()).get());
        appuntamento.setMedico(medicoRepository.findById(updatedAppuntamento.getId_medico()).get());
        appuntamento.setVisita(visitaRepository.findById(updatedAppuntamento.getId_visita()).get());
        appuntamento.setSlot(slotRepository.findById(updatedAppuntamento.getId_slot()).get());

        Appuntamento updatedAppuntamentoObj = appuntamentoRepository.save(appuntamento);

        return AppuntamentoMapper.mapToAppuntamentoDto(updatedAppuntamentoObj);
    }

    @Override
    public void deleteAppuntamento(Long id_appuntamento){
        appuntamentoRepository.findById(id_appuntamento)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_appuntamento));
        appuntamentoRepository.deleteById(id_appuntamento);
    }

    @Override
    public List<AppuntamentoDto> getAppuntamentiByMedico(Long id_medico){
        Medico medico = medicoRepository.findById(id_medico).get();
        List<Appuntamento> appuntamenti = appuntamentoRepository.findByMedico(medico);
        return appuntamenti.stream().map((appuntamento) -> AppuntamentoMapper.mapToAppuntamentoDto(appuntamento))
            .collect(Collectors.toList());
    }

    @Override
    public List<AppuntamentoDto> getAppuntamentiByPaziente(Long id_paziente){
        Paziente paziente = pazienteRepository.findById(id_paziente).get();
        List<Appuntamento> appuntamenti = appuntamentoRepository.findByPaziente(paziente);
        return appuntamenti.stream().map((appuntamento) -> AppuntamentoMapper.mapToAppuntamentoDto(appuntamento))
            .collect(Collectors.toList());
    }
}
