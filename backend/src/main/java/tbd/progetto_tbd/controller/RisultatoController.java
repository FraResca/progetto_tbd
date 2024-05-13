package tbd.progetto_tbd.controller;


import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.service.RisultatoService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/risultati")
@AllArgsConstructor
public class RisultatoController {
    private RisultatoService risultatoService;
    
    @PostMapping
    public ResponseEntity<RisultatoDto> createRisultato(@RequestBody RisultatoDto risultatoDto){
        RisultatoDto savedRisultato = risultatoService.createRisultato(risultatoDto);
        return new ResponseEntity<>(savedRisultato,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getRisultatoById(@PathVariable("id")Long id_risultato){
        RisultatoDto risultatoDto = risultatoService.getRisultatoById(id_risultato);
        return ResponseEntity.ok(risultatoDto);
    }

    @GetMapping("/paziente/{id}")
    public ResponseEntity<?> getRisultatiByPaziente(@PathVariable("id")Long id_paziente){
        List<RisultatoDto> risultati = risultatoService.getRisultatiByPaziente(id_paziente);
        return ResponseEntity.ok(risultati);
    }

    @GetMapping
    public ResponseEntity<List<RisultatoDto>> getAllRisultati(){
        List<RisultatoDto> risultati = risultatoService.getAllRisultati();
        return ResponseEntity.ok(risultati);
    }

    @PutMapping("{id}")
    public ResponseEntity<RisultatoDto> updateRisultato(@PathVariable("id")Long id_risultato, @RequestBody RisultatoDto updatedRisultato){
        RisultatoDto risultatoDto = risultatoService.updateRisultato(id_risultato, updatedRisultato);
        return ResponseEntity.ok(risultatoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRisultato(@PathVariable("id")Long id_risultato){
        risultatoService.deleteRisultato(id_risultato);
        return ResponseEntity.ok("Risultato cancellato con successo");
    }

    @GetMapping("/appuntamento/{id}")
    public ResponseEntity<?> getRisultatiByApp(@PathVariable("id")Long id_appuntamento){
        List<RisultatoDto> risultati = risultatoService.getRisultatiByApp(id_appuntamento);
        return ResponseEntity.ok(risultati);
    }
}