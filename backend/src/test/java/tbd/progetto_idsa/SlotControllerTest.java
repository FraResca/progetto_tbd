package tbd.progetto_idsa;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tbd.progetto_tbd.dto.SlotDto;
import tbd.progetto_tbd.service.SlotService;

import java.sql.Date;
import java.sql.Time;
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
public class SlotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SlotService slotsService;

    @Test
    public void testGetAllSlots() throws Exception {
        SlotDto slotsDto = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        List<SlotDto> slots = Collections.singletonList(slotsDto);
        when(slotsService.getAllSlots()).thenReturn(slots);

        mockMvc.perform(get("/api/slots")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id_slot", is(slotsDto.getId_slot().intValue())))
                .andExpect(jsonPath("$[0].dataSlot", is(slotsDto.getDataSlot().toString())))
                .andExpect(jsonPath("$[0].oraSlot", is(slotsDto.getOraSlot().toString())))
                .andExpect(jsonPath("$[0].occupato", is(slotsDto.getOccupato())));
    }

    @Test
    public void testGetSlotById() throws Exception {
        SlotDto slotsDto = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        when(slotsService.getSlotById(1L)).thenReturn(slotsDto);

        mockMvc.perform(get("/api/slots/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_slot", is(slotsDto.getId_slot().intValue())))
                .andExpect(jsonPath("$.dataSlot", is(slotsDto.getDataSlot().toString())))
                .andExpect(jsonPath("$.oraSlot", is(slotsDto.getOraSlot().toString())))
                .andExpect(jsonPath("$.occupato", is(slotsDto.getOccupato())));
    }

    @Test
    public void testCreateSlot() throws Exception {
        SlotDto slotsDto = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        when(slotsService.createSlot(any(SlotDto.class))).thenReturn(slotsDto);
        
        mockMvc.perform(post("/api/slots")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"dataSlot\": \"2021-10-10\",\n" +
                        "    \"oraSlot\": \"10:00:00\",\n" +
                        "    \"occupato\": false\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id_slot", is(slotsDto.getId_slot().intValue())))
                .andExpect(jsonPath("$.dataSlot", is(slotsDto.getDataSlot().toString())))
                .andExpect(jsonPath("$.oraSlot", is(slotsDto.getOraSlot().toString())))
                .andExpect(jsonPath("$.occupato", is(slotsDto.getOccupato())));
    }

    @Test
    public void testUpdateSlot() throws Exception {
        SlotDto slotsDto = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        when(slotsService.updateSlot(any(Long.class), any(SlotDto.class))).thenReturn(slotsDto);

        mockMvc.perform(put("/api/slots/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"dataSlot\": \"2021-10-10\",\n" +
                        "    \"oraSlot\": \"10:00:00\",\n" +
                        "    \"occupato\": false\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id_slot", is(slotsDto.getId_slot().intValue())))
                .andExpect(jsonPath("$.dataSlot", is(slotsDto.getDataSlot().toString())))
                .andExpect(jsonPath("$.oraSlot", is(slotsDto.getOraSlot().toString())))
                .andExpect(jsonPath("$.occupato", is(slotsDto.getOccupato())));
    }

    @Test
    public void testDeleteSlot() throws Exception {
        doNothing().when(slotsService).deleteSlot(1L);

        mockMvc.perform(delete("/api/slots/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
