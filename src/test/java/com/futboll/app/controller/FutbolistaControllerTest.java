package com.futboll.app.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FutbolistaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFutbolistas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/futbolista"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].idFutbolista").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombres").value("Lionel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].apellidos").value("Messi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].fechaNacido").value("1987-06-24"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].posicion.idPosicion").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].posicion.nombre").value("DELANTERO"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].caracteristicas").value("Habilidoso, excelente regate y visión de juego"));
    }
}
