package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.MedicoDto;
import tbd.progetto_tbd.service.MedicoService;

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
public class MedicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicoService mediciService;

    @Test
    public void testGetAllMedici() throws Exception {
        MedicoDto mediciDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Cardiologia");
        List<MedicoDto> medici = Collections.singletonList(mediciDto);
        when(mediciService.getAllMedici()).thenReturn(medici);

        mockMvc.perform(get("/api/medici")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_utente", is(mediciDto.getId_utente().intValue())))
                .andExpect(jsonPath("$[0].nome", is(mediciDto.getNome())))
                .andExpect(jsonPath("$[0].cognome", is(mediciDto.getCognome())))
                .andExpect(jsonPath("$[0].data_n", is(mediciDto.getData_n().toString())))
                .andExpect(jsonPath("$[0].cf", is(mediciDto.getCf())))
                .andExpect(jsonPath("$[0].email", is(mediciDto.getEmail())))
                .andExpect(jsonPath("$[0].password", is(mediciDto.getPassword())))
                .andExpect(jsonPath("$[0].stipendio", is(mediciDto.getStipendio().doubleValue())))
                .andExpect(jsonPath("$[0].specializ", is(mediciDto.getSpecializ())));
    }

    @Test
    public void testGetMedicoById() throws Exception {
        MedicoDto mediciDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Cardiologia");
        when(mediciService.getMedicoById(1L)).thenReturn(mediciDto);

        mockMvc.perform(get("/api/medici/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_utente", is(mediciDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(mediciDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(mediciDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(mediciDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(mediciDto.getCf())))
                .andExpect(jsonPath("$.email", is(mediciDto.getEmail())))
                .andExpect(jsonPath("$.password", is(mediciDto.getPassword())))
                .andExpect(jsonPath("$.stipendio", is(mediciDto.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(mediciDto.getSpecializ())));
    }

    @Test
    public void testCreateMedico() throws Exception {
        MedicoDto mediciDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Cardiologia");
        when(mediciService.createMedico(any(MedicoDto.class))).thenReturn(mediciDto);
        
        mockMvc.perform(post("/api/medici")
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
                .andExpect(jsonPath("$.id_utente", is(mediciDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(mediciDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(mediciDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(mediciDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(mediciDto.getCf())))
                .andExpect(jsonPath("$.email", is(mediciDto.getEmail())))
                .andExpect(jsonPath("$.password", is(mediciDto.getPassword())))
                .andExpect(jsonPath("$.stipendio", is(mediciDto.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(mediciDto.getSpecializ())));
    }

    @Test
    public void testUpdateMedico() throws Exception {
        MedicoDto mediciDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella", "Password", 1000.0f, "Cardiologia");
        when(mediciService.updateMedico(any(Long.class), any(MedicoDto.class))).thenReturn(mediciDto);

        mockMvc.perform(put("/api/medici/1")
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
                .andExpect(jsonPath("$.id_utente", is(mediciDto.getId_utente().intValue())))
                .andExpect(jsonPath("$.nome", is(mediciDto.getNome())))
                .andExpect(jsonPath("$.cognome", is(mediciDto.getCognome())))
                .andExpect(jsonPath("$.data_n", is(mediciDto.getData_n().toString())))
                .andExpect(jsonPath("$.cf", is(mediciDto.getCf())))
                .andExpect(jsonPath("$.email", is(mediciDto.getEmail())))
                .andExpect(jsonPath("$.password", is(mediciDto.getPassword())))
                .andExpect(jsonPath("$.stipendio", is(mediciDto.getStipendio().doubleValue())))
                .andExpect(jsonPath("$.specializ", is(mediciDto.getSpecializ())));
    }

    @Test
    public void testDeleteMedico() throws Exception {
        doNothing().when(mediciService).deleteMedico(1L);

        mockMvc.perform(delete("/api/medici/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
