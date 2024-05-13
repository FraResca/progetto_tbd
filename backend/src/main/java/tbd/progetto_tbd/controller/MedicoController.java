package tbd.progetto_tbd.controller;


import tbd.progetto_tbd.dto.MedicoDto;
import tbd.progetto_tbd.service.MedicoService;
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
@RequestMapping("/api/medici")
@AllArgsConstructor
public class MedicoController {
    private MedicoService medicoService;
    @PostMapping
    public ResponseEntity<MedicoDto> createMedico(@RequestBody MedicoDto medicoDto){
        MedicoDto savedMedico = medicoService.createMedico(medicoDto);
        return new ResponseEntity<>(savedMedico,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMedicoById(@PathVariable("id")Long id_medico){
        MedicoDto medicoDto = medicoService.getMedicoById(id_medico);
        return ResponseEntity.ok(medicoDto);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDto>> getAllMedici(){
        List<MedicoDto> medici = medicoService.getAllMedici();
        return ResponseEntity.ok(medici);
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicoDto> updateMedico(@PathVariable("id")Long id_medico, @RequestBody MedicoDto updatedMedico){
        MedicoDto medicoDto = medicoService.updateMedico(id_medico, updatedMedico);
        return ResponseEntity.ok(medicoDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable("id")Long id_medico){
        medicoService.deleteMedico(id_medico);
        return ResponseEntity.ok("Medico cancellato con successo");
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<MedicoDto> getMedicoByEmail(@PathVariable("email")String email){
        MedicoDto medicoDto = medicoService.getMedicoByEmail(email);
        return ResponseEntity.ok(medicoDto);
    }
}