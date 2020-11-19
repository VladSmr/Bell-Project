package com.bell.project;

import com.bell.project.view.office.OfficeFilter;
import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewSave;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Boolean.TRUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class OfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOfficeById() throws Exception {
        mockMvc.perform(
                get("/api/office/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Office"))
                .andExpect(jsonPath("$.data.address").value("Moscow, 100"))
                .andExpect(jsonPath("$.data.phone").value("88001234567"))
                .andExpect(jsonPath("$.data.isActive").value(TRUE));
    }

    @Test
    public void getOfficeByOrg() throws Exception {
        OfficeFilter of = new OfficeFilter();
        of.orgId = 1L;
        of.name = "Office";
        of.phone = "88001234567";
        of.isActive = TRUE;
        mockMvc.perform(
                post("/api/office/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(of)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data..id").value(1))
                .andExpect(jsonPath("$.data..name").value("Office"))
                .andExpect(jsonPath("$.data..isActive").value(TRUE));
    }

    @Test
    public void saveOffice() throws Exception {
        OfficeViewSave of = new OfficeViewSave();
        of.orgId = 1L;
        of.name = "Aq";
        of.address = "Mosc";
        of.phone = "798456";
        of.isActive = TRUE;

        mockMvc.perform(
                post("/api/office/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(of)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/office/4")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(4))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value(of.name))
                .andExpect(jsonPath("$.data.address").value(of.address))
                .andExpect(jsonPath("$.data.phone").value(of.phone))
                .andExpect(jsonPath("$.data.isActive").value(of.isActive));
    }

    @Test
    public void updateOffice() throws Exception {
        mockMvc.perform(
                get("/api/office/3")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(3))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Office3"))
                .andExpect(jsonPath("$.data.address").value("Moscow, 150"))
                .andExpect(jsonPath("$.data.phone").value("88001234569"))
                .andExpect(jsonPath("$.data.isActive").value(TRUE));

        OfficeView of = new OfficeView();
        of.id = 3L;
        of.name = "Aq";
        of.address = "Mosc";
        of.phone = "798456";
        of.isActive = TRUE;

        mockMvc.perform(
                post("/api/office/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(of)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/office/3")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(3))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value(of.name))
                .andExpect(jsonPath("$.data.address").value(of.address))
                .andExpect(jsonPath("$.data.phone").value(of.phone))
                .andExpect(jsonPath("$.data.isActive").value(of.isActive));
    }
}