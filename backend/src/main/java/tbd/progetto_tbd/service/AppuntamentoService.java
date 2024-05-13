package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.AppuntamentoDto;

public interface AppuntamentoService {
    AppuntamentoDto createAppuntamento(AppuntamentoDto appuntamentoDto);
    AppuntamentoDto getAppuntamentoById(Long id_app);
    List<AppuntamentoDto> getAllAppuntamenti();
    AppuntamentoDto updateAppuntamento(Long id_app, AppuntamentoDto updatedAppuntamento);
    void deleteAppuntamento(Long id_app);
    List<AppuntamentoDto> getAppuntamentiByMedico(Long id_medico);
    List<AppuntamentoDto> getAppuntamentiByPaziente(Long id_paziente);
}
