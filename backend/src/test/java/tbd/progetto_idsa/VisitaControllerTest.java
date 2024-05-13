package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.VisitaDto;
import tbd.progetto_tbd.service.VisitaService;

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
public class VisitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitaService visiteService;

    @Test
    public void testGetAllVisite() throws Exception {
        VisitaDto visiteDto = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        List<VisitaDto> visite = Collections.singletonList(visiteDto);
        when(visiteService.getAllVisite()).thenReturn(visite);

        mockMvc.perform(get("/api/visite")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_vis", is(visiteDto.getId_vis().intValue())))
                .andExpect(jsonPath("$[0].tipoVis", is(visiteDto.getTipoVis())))
                .andExpect(jsonPath("$[0].descr", is(visiteDto.getDescr())))
                .andExpect(jsonPath("$[0].prezzo", is(visiteDto.getPrezzo().doubleValue())))
                .andExpect(jsonPath("$[0].id_medico", is(visiteDto.getId_medico().intValue())));
    }

    @Test
    public void testGetVisitaById() throws Exception {
        VisitaDto visiteDto = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        when(visiteService.getVisitaById(1L)).thenReturn(visiteDto);

        mockMvc.perform(get("/api/visite/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_vis", is(visiteDto.getId_vis().intValue())))
                .andExpect(jsonPath("$.tipoVis", is(visiteDto.getTipoVis())))
                .andExpect(jsonPath("$.descr", is(visiteDto.getDescr())))
                .andExpect(jsonPath("$.prezzo", is(visiteDto.getPrezzo().doubleValue())))
                .andExpect(jsonPath("$.id_medico", is(visiteDto.getId_medico().intValue())));
        }

    @Test
    public void testCreateVisita() throws Exception {
        VisitaDto visiteDto = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        when(visiteService.createVisita(any(VisitaDto.class))).thenReturn(visiteDto);
        
        mockMvc.perform(post("/api/visite")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"tipoVis\": \"Cardiologica\",\n" +
                        "    \"descr\": \"Visita cardiologica\",\n" +
                        "    \"prezzo\": 50,\n" +
                        "    \"id_medico\": 1\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_vis", is(visiteDto.getId_vis().intValue())))
                .andExpect(jsonPath("$.tipoVis", is(visiteDto.getTipoVis())))
                .andExpect(jsonPath("$.descr", is(visiteDto.getDescr())))
                .andExpect(jsonPath("$.prezzo", is(visiteDto.getPrezzo().doubleValue())))
                .andExpect(jsonPath("$.id_medico", is(visiteDto.getId_medico().intValue())));
    }

    @Test
    public void testUpdateVisita() throws Exception {
        VisitaDto visiteDto = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        when(visiteService.updateVisita(any(Long.class), any(VisitaDto.class))).thenReturn(visiteDto);

        mockMvc.perform(put("/api/visite/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"tipoVis\": \"Cardiologica\",\n" +
                        "    \"descr\": \"Visita cardiologica\",\n" +
                        "    \"prezzo\": 50,\n" +
                        "    \"id_medico\": 1\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_vis", is(visiteDto.getId_vis().intValue())))
                .andExpect(jsonPath("$.tipoVis", is(visiteDto.getTipoVis())))
                .andExpect(jsonPath("$.descr", is(visiteDto.getDescr())))
                .andExpect(jsonPath("$.prezzo", is(visiteDto.getPrezzo().doubleValue())))
                .andExpect(jsonPath("$.id_medico", is(visiteDto.getId_medico().intValue())));
    }

    @Test
    public void testDeleteVisita() throws Exception {
        doNothing().when(visiteService).deleteVisita(1L);

        mockMvc.perform(delete("/api/visite/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
