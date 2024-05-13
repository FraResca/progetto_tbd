package tbd.progetto_tbd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.RisultatoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.service.RisultatoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RisultatoServiceImpl implements RisultatoService {
    @Autowired
    private RisultatoRepository risultatoRepository;
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;
    @Autowired
    private PazienteRepository pazienteRepository;

    @Override
    public RisultatoDto createRisultato(RisultatoDto risultatoDto) {
        Risultato risultato = RisultatoMapper.mapToRisultato(risultatoDto, appuntamentoRepository);
        risultato.setAppuntamento(appuntamentoRepository.findById(risultatoDto.getId_appuntamento()).get());
        Risultato savedRisultato = risultatoRepository.save(risultato);
        return RisultatoMapper.mapToRisultatoDto(savedRisultato);
    }
    
    @Override
    public RisultatoDto getRisultatoById(Long id_risultato){
        Risultato risultato = risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
            return RisultatoMapper.mapToRisultatoDto(risultato);
    }

    @Override
    public List<RisultatoDto> getAllRisultati(){
        List<Risultato> risultati = risultatoRepository.findAll();
        return risultati.stream().map((risultato) -> RisultatoMapper.mapToRisultatoDto(risultato))
            .collect(Collectors.toList());
    }

    @Override
    public RisultatoDto updateRisultato(Long id_risultato, RisultatoDto updatedRisultato){
        Risultato risultato = risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
        risultato.setReferto(updatedRisultato.getReferto());
        risultato.setPrescr(updatedRisultato.getPrescr());
        risultato.setAppuntamento(appuntamentoRepository.findById(updatedRisultato.getId_appuntamento()).get());
        
        Risultato updatedRisultatoObj = risultatoRepository.save(risultato);

        return RisultatoMapper.mapToRisultatoDto(updatedRisultatoObj);
    }

    @Override
    public void deleteRisultato(Long id_risultato){
        risultatoRepository.findById(id_risultato)
            .orElseThrow(() -> new ResourceNotFoundException("Risultato non esiste per l'id dato : " + id_risultato));
        risultatoRepository.deleteById(id_risultato);
    }

    @Override
    public List<RisultatoDto> getRisultatiByPaziente(Long id_utente){
        Paziente paziente = pazienteRepository.findById(id_utente)
            .orElseThrow(() -> new ResourceNotFoundException("Paziente non esiste per l'id dato : " + id_utente));
        List<Appuntamento> appuntamenti = appuntamentoRepository.findByPaziente(paziente);

        List<RisultatoDto> risultatiDto = new ArrayList<>();
        List<Risultato> risultati = new ArrayList<>();
        
        for(Appuntamento appuntamento : appuntamenti){
            risultati = risultatoRepository.findByAppuntamento(appuntamento);
            for(Risultato ris : risultati){
                risultatiDto.add(RisultatoMapper.mapToRisultatoDto(ris));
            }
        }
        return risultatiDto;
    }

    @Override
    public List<RisultatoDto> getRisultatiByApp(Long id_app){
        Appuntamento appuntamento = appuntamentoRepository.findById(id_app)
            .orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + id_app));
        List<Risultato> risultati = risultatoRepository.findByAppuntamento(appuntamento);
        return risultati.stream().map((risultato) -> RisultatoMapper.mapToRisultatoDto(risultato))
            .collect(Collectors.toList());
    }
}
