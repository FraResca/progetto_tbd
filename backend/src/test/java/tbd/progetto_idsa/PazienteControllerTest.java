package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.PazienteDto;
import tbd.progetto_tbd.service.PazienteService;

import java.sql.Date;
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
public class PazienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PazienteService pazienteService;

    @Test
    public void testGetAllPazienti() throws Exception {
        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        List<PazienteDto> pazienti = Collections.singletonList(pazienteDto);
        when(pazienteService.getAllPazienti()).thenReturn(pazienti);

        mockMvc.perform(get("/api/pazienti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_utente", is(pazienteDto.getId_utente().intValue())))
                .andExpect(jsonPath("$[0].nome", is(pazienteDto.getNome())))
                .andExpect(jsonPath("$[0].cognome", is(pazienteDto.getCognome())))
                .andExpect(jsonPath("$[0].data_n", is(pazienteDto.getData_n().toString())))
                .andExpect(jsonPath("$[0].cf", is(pazienteDto.getCf())))
                .andExpect(jsonPath("$[0].email", is(pazienteDto.getEmail())))
                .andExpect(jsonPath("$[0].password", is(pazienteDto.getPassword())));
    }

    @Test
    public void testGetPazienteById() throws Exception {
        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        when(pazienteService.getPazienteById(1L)).thenReturn(pazienteDto);

        mockMvc.perform(get("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_utente", is(pazienteDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(pazienteDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(pazienteDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(pazienteDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(pazienteDto.getCf())))
                .andExpect(jsonPath("$.email", is(pazienteDto.getEmail())))
                .andExpect(jsonPath("$.password", is(pazienteDto.getPassword())));
    }

    @Test
    public void testCreatePaziente() throws Exception {
        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        when(pazienteService.createPaziente(any(PazienteDto.class))).thenReturn(pazienteDto);
        
        mockMvc.perform(post("/api/pazienti")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"nome\": \"Nome\",\n" +
                        "    \"cognome\": \"Cognome\",\n" +
                        "    \"data_n\": \"1999-10-10\",\n" +
                        "    \"cf\": \"Codice_Fiscale\",\n" +
                        "    \"email\": \"email@casella.cose\",\n" +
                        "    \"password\": \"Password\"\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_utente", is(pazienteDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(pazienteDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(pazienteDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(pazienteDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(pazienteDto.getCf())))
                .andExpect(jsonPath("$.email", is(pazienteDto.getEmail())))
                .andExpect(jsonPath("$.password", is(pazienteDto.getPassword())));
    }

    @Test
    public void testUpdatePaziente() throws Exception {
        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella", "Password");
        when(pazienteService.updatePaziente(any(Long.class), any(PazienteDto.class))).thenReturn(pazienteDto);

        mockMvc.perform(put("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"nome\": \"Nome\",\n" +
                        "    \"cognome\": \"Cognome\",\n" +
                        "    \"data_n\": \"1999-10-10\",\n" +
                        "    \"cf\": \"Codice_Fiscale\",\n" +
                        "    \"email\": \"email@casella\",\n" +
                        "    \"password\": \"Password\"\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_utente", is(pazienteDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(pazienteDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(pazienteDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(pazienteDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(pazienteDto.getCf())))
                .andExpect(jsonPath("$.email", is(pazienteDto.getEmail())))
                .andExpect(jsonPath("$.password", is(pazienteDto.getPassword())));
    }

    @Test
    public void testDeletePaziente() throws Exception {
        doNothing().when(pazienteService).deletePaziente(1L);

        mockMvc.perform(delete("/api/pazienti/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
