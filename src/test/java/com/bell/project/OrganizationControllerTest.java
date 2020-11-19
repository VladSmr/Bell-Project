package com.bell.project;

import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationViewSave;
import com.bell.project.view.organization.OrganizationViewUpdate;
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
public class OrganizationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getOrganizationById() throws Exception {
        mockMvc.perform(
                get("/api/organization/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Sber"))
                .andExpect(jsonPath("$.data.fullName").value("Sberbank"))
                .andExpect(jsonPath("$.data.inn").value("1234567890"))
                .andExpect(jsonPath("$.data.kpp").value("123456789"))
                .andExpect(jsonPath("$.data.address").value("Moscow, 50"))
                .andExpect(jsonPath("$.data.phone").value("88001111111"))
                .andExpect(jsonPath("$.data.isActive").value(TRUE));
    }

    @Test
    public void getOrganizationByName() throws Exception {
        OrganizationFilter or = new OrganizationFilter();
        or.name = "Sber";
        or.inn = "1234567890";
        or.isActive = TRUE;
        mockMvc.perform(
                post("/api/organization/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(or)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data..id").value("1"))
                .andExpect(jsonPath("$.data..name").value("Sber"))
                .andExpect(jsonPath("$.data..isActive").value(TRUE));
    }

    @Test
    public void saveOrganization() throws Exception {
        OrganizationViewSave or = new OrganizationViewSave();
        or.name = "Aq";
        or.fullName = "Aqua";
        or.inn = "3216549870";
        or.kpp = "963852741";
        or.address = "Mosc";
        or.phone = "798456";
        or.isActive = TRUE;

        mockMvc.perform(
                post("/api/organization/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(or)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/organization/3")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(3))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value(or.name))
                .andExpect(jsonPath("$.data.fullName").value(or.fullName))
                .andExpect(jsonPath("$.data.inn").value(or.inn))
                .andExpect(jsonPath("$.data.kpp").value(or.kpp))
                .andExpect(jsonPath("$.data.address").value(or.address))
                .andExpect(jsonPath("$.data.phone").value(or.phone))
                .andExpect(jsonPath("$.data.isActive").value(or.isActive));
    }

    @Test
    public void updateOrganization() throws Exception {
        mockMvc.perform(
                get("/api/organization/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value("Sber"))
                .andExpect(jsonPath("$.data.fullName").value("Sberbank"))
                .andExpect(jsonPath("$.data.inn").value("1234567890"))
                .andExpect(jsonPath("$.data.kpp").value("123456789"))
                .andExpect(jsonPath("$.data.address").value("Moscow, 50"))
                .andExpect(jsonPath("$.data.phone").value("88001111111"))
                .andExpect(jsonPath("$.data.isActive").value(TRUE));

        OrganizationViewUpdate or = new OrganizationViewUpdate();
        or.id = "1";
        or.name = "Aq";
        or.fullName = "Aqua";
        or.inn = "3216549870";
        or.kpp = "963852741";
        or.address = "Mosc";
        or.phone = "798456";
        or.isActive = TRUE;

        mockMvc.perform(
                post("/api/organization/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(or)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/organization/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.name").value(or.name))
                .andExpect(jsonPath("$.data.fullName").value(or.fullName))
                .andExpect(jsonPath("$.data.inn").value(or.inn))
                .andExpect(jsonPath("$.data.kpp").value(or.kpp))
                .andExpect(jsonPath("$.data.address").value(or.address))
                .andExpect(jsonPath("$.data.phone").value(or.phone))
                .andExpect(jsonPath("$.data.isActive").value(or.isActive));
    }
}