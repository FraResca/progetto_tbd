package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.service.RisultatoService;

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
public class RisultatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RisultatoService risultatiService;

    @Test
    public void testGetAllRisultati() throws Exception {
        RisultatoDto risultatiDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        List<RisultatoDto> risultati = Collections.singletonList(risultatiDto);
        when(risultatiService.getAllRisultati()).thenReturn(risultati);

        mockMvc.perform(get("/api/risultati")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_ris", is(risultatiDto.getId_ris().intValue())))
                .andExpect(jsonPath("$[0].referto", is(risultatiDto.getReferto())))
                .andExpect(jsonPath("$[0].prescr", is(risultatiDto.getPrescr())))
                .andExpect(jsonPath("$[0].id_appuntamento", is(risultatiDto.getId_appuntamento().intValue())));
    }

    @Test
    public void testGetRisultatoById() throws Exception {
        RisultatoDto risultatiDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        when(risultatiService.getRisultatoById(1L)).thenReturn(risultatiDto);

        mockMvc.perform(get("/api/risultati/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_ris", is(risultatiDto.getId_ris().intValue())))
                .andExpect(jsonPath("$.referto", is(risultatiDto.getReferto())))
                .andExpect(jsonPath("$.prescr", is(risultatiDto.getPrescr())))
                .andExpect(jsonPath("$.id_appuntamento", is(risultatiDto.getId_appuntamento().intValue())));
    }

    @Test
    public void testCreateRisultato() throws Exception {
        RisultatoDto risultatiDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        when(risultatiService.createRisultato(any(RisultatoDto.class))).thenReturn(risultatiDto);
        
        mockMvc.perform(post("/api/risultati")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"referto\": \"Referto\",\n" +
                        "    \"prescr\": \"Prescrizione\",\n" +
                        "    \"id_appuntamento\": 1\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_ris", is(risultatiDto.getId_ris().intValue())))
                .andExpect(jsonPath("$.referto", is(risultatiDto.getReferto())))
                .andExpect(jsonPath("$.prescr", is(risultatiDto.getPrescr())))
                .andExpect(jsonPath("$.id_appuntamento", is(risultatiDto.getId_appuntamento().intValue())));
    }

    @Test
    public void testUpdateRisultato() throws Exception {
        RisultatoDto risultatiDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        when(risultatiService.updateRisultato(any(Long.class), any(RisultatoDto.class))).thenReturn(risultatiDto);

        mockMvc.perform(put("/api/risultati/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"referto\": \"Referto\",\n" +
                        "    \"prescr\": \"Prescrizione\",\n" +
                        "    \"id_appuntametno\": 1\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_ris", is(risultatiDto.getId_ris().intValue())))
                .andExpect(jsonPath("$.referto", is(risultatiDto.getReferto())))
                .andExpect(jsonPath("$.prescr", is(risultatiDto.getPrescr())))
                .andExpect(jsonPath("$.id_appuntamento", is(risultatiDto.getId_appuntamento().intValue())));
    }

    @Test
    public void testDeleteRisultato() throws Exception {
        doNothing().when(risultatiService).deleteRisultato(1L);

        mockMvc.perform(delete("/api/risultati/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
