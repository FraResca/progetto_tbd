package tbd.progetto_tbd.controller;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.service.AppuntamentoService;
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
@RequestMapping("/api/appuntamenti")
@AllArgsConstructor
public class AppuntamentoController {
    private AppuntamentoService appuntamentoService;
    @PostMapping
    public ResponseEntity<AppuntamentoDto> createAppuntamento(@RequestBody AppuntamentoDto appuntamentoDto){
        AppuntamentoDto savedAppuntamento = appuntamentoService.createAppuntamento(appuntamentoDto);
        return new ResponseEntity<>(savedAppuntamento,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAppuntamentoById(@PathVariable("id")Long id_appuntamento){
        AppuntamentoDto appuntamentoDto = appuntamentoService.getAppuntamentoById(id_appuntamento);
        return ResponseEntity.ok(appuntamentoDto);
    }

    @GetMapping("medico/{id_medico}")
    public ResponseEntity<?> getAppuntamentiByMedico(@PathVariable("id_medico")Long id_medico){
        List<AppuntamentoDto> appuntamenti = appuntamentoService.getAppuntamentiByMedico(id_medico);
        return ResponseEntity.ok(appuntamenti);
    }

    @GetMapping("paziente/{id_paziente}")
    public ResponseEntity<?> getAppuntamentiByPaziente(@PathVariable("id_paziente")Long id_paziente){
        List<AppuntamentoDto> appuntamenti = appuntamentoService.getAppuntamentiByPaziente(id_paziente);
        return ResponseEntity.ok(appuntamenti);
    }

    @GetMapping
    public ResponseEntity<List<AppuntamentoDto>> getAllAppuntamenti(){
        List<AppuntamentoDto> appuntamenti = appuntamentoService.getAllAppuntamenti();
        return ResponseEntity.ok(appuntamenti);
    }

    @PutMapping("{id}")
    public ResponseEntity<AppuntamentoDto> updateAppuntamento(@PathVariable("id")Long id_appuntamento, @RequestBody AppuntamentoDto updatedAppuntamento){
        AppuntamentoDto appuntamentoDto = appuntamentoService.updateAppuntamento(id_appuntamento, updatedAppuntamento);
        return ResponseEntity.ok(appuntamentoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppuntamento(@PathVariable("id")Long id_appuntamento){
        appuntamentoService.deleteAppuntamento(id_appuntamento);
        return ResponseEntity.ok("Appuntamento cancellato con successo");
    }
}