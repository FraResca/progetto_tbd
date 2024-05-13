package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.service.AppuntamentoService;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
public class AppuntamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppuntamentoService appuntamentiService;

    @Test
    public void testGetAllAppuntamenti() throws Exception {
        AppuntamentoDto appuntamentiDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        List<AppuntamentoDto> appuntamenti = Collections.singletonList(appuntamentiDto);
        when(appuntamentiService.getAllAppuntamenti()).thenReturn(appuntamenti);

        mockMvc.perform(get("/api/appuntamenti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_app", is(appuntamentiDto.getId_app().intValue())))
                .andExpect(jsonPath("$[0].pagato", is(appuntamentiDto.getPagato())))
                .andExpect(jsonPath("$[0].id_paziente", is(appuntamentiDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$[0].id_medico", is(appuntamentiDto.getId_medico().intValue())))
                .andExpect(jsonPath("$[0].id_visita", is(appuntamentiDto.getId_visita().intValue())))
                .andExpect(jsonPath("$[0].id_slot", is(appuntamentiDto.getId_slot().intValue())));

    }

    @Test
    public void testGetAppuntamentoById() throws Exception {
        AppuntamentoDto appuntamentiDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        when(appuntamentiService.getAppuntamentoById(1L)).thenReturn(appuntamentiDto);

        mockMvc.perform(get("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_app", is(appuntamentiDto.getId_app().intValue())))
                .andExpect(jsonPath("$.pagato", is(appuntamentiDto.getPagato())))
                .andExpect(jsonPath("$.id_paziente", is(appuntamentiDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$.id_medico", is(appuntamentiDto.getId_medico().intValue())))
                .andExpect(jsonPath("$.id_visita", is(appuntamentiDto.getId_visita().intValue())))
                .andExpect(jsonPath("$.id_slot", is(appuntamentiDto.getId_slot().intValue())));
    }

    @Test
    public void testGetAppuntamentiByMedico() throws Exception {
        AppuntamentoDto appuntamentiDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        List<AppuntamentoDto> appuntamenti = Collections.singletonList(appuntamentiDto);
        when(appuntamentiService.getAppuntamentiByMedico(1L)).thenReturn(appuntamenti);

        mockMvc.perform(get("/api/appuntamenti/medico/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_app", is(appuntamentiDto.getId_app().intValue())))
                .andExpect(jsonPath("$[0].pagato", is(appuntamentiDto.getPagato())))
                .andExpect(jsonPath("$[0].id_paziente", is(appuntamentiDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$[0].id_medico", is(appuntamentiDto.getId_medico().intValue())))
                .andExpect(jsonPath("$[0].id_visita", is(appuntamentiDto.getId_visita().intValue())))
                .andExpect(jsonPath("$[0].id_slot", is(appuntamentiDto.getId_slot().intValue())));
    }

    @Test
    public void testCreateAppuntamento() throws Exception {
        AppuntamentoDto appuntamentiDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        when(appuntamentiService.createAppuntamento(any(AppuntamentoDto.class))).thenReturn(appuntamentiDto);
        
        mockMvc.perform(post("/api/appuntamenti")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"pagato\": false,\n" +
                        "    \"id_paziente\": 1,\n" +
                        "    \"id_medico\": 1,\n" +
                        "    \"id_visita\": 1,\n" +
                        "    \"id_slot\": 1\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_app", is(appuntamentiDto.getId_app().intValue())))
                .andExpect(jsonPath("$.pagato", is(appuntamentiDto.getPagato())))
                .andExpect(jsonPath("$.id_paziente", is(appuntamentiDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$.id_medico", is(appuntamentiDto.getId_medico().intValue())))
                .andExpect(jsonPath("$.id_visita", is(appuntamentiDto.getId_visita().intValue())))
                .andExpect(jsonPath("$.id_slot", is(appuntamentiDto.getId_slot().intValue())));
    }

    @Test
    public void testUpdateAppuntamento() throws Exception {
        AppuntamentoDto appuntamentiDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        when(appuntamentiService.updateAppuntamento(any(Long.class), any(AppuntamentoDto.class))).thenReturn(appuntamentiDto);

        mockMvc.perform(put("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"pagato\": false,\n" +
                        "    \"id_paziente\": 1,\n" +
                        "    \"id_medico\": 1,\n" +
                        "    \"id_visita\": 1,\n" +
                        "    \"id_slot\": 1\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_app", is(appuntamentiDto.getId_app().intValue())))
                .andExpect(jsonPath("$.pagato", is(appuntamentiDto.getPagato())))
                .andExpect(jsonPath("$.id_paziente", is(appuntamentiDto.getId_paziente().intValue())))
                .andExpect(jsonPath("$.id_medico", is(appuntamentiDto.getId_medico().intValue())))
                .andExpect(jsonPath("$.id_visita", is(appuntamentiDto.getId_visita().intValue())))
                .andExpect(jsonPath("$.id_slot", is(appuntamentiDto.getId_slot().intValue())));
    }

    @Test
    public void testDeleteAppuntamento() throws Exception {
        doNothing().when(appuntamentiService).deleteAppuntamento(1L);

        mockMvc.perform(delete("/api/appuntamenti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
