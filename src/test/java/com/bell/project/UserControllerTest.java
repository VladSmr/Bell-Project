package com.bell.project;

import com.bell.project.view.user.UserFilter;
import com.bell.project.view.user.UserViewSave;
import com.bell.project.view.user.UserViewUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.text.SimpleDateFormat;

import static java.lang.Boolean.TRUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserById() throws Exception {
        mockMvc.perform(
                get("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.firstName").value("John"))
                .andExpect(jsonPath("$.data.secondName").value("Smith"))
                .andExpect(jsonPath("$.data.middleName").value("JS"))
                .andExpect(jsonPath("$.data.position").value("Worker"))
                .andExpect(jsonPath("$.data.phone").value("5551100"))
                .andExpect(jsonPath("$.data.documentName").value("Паспорт гражданина Российской Федерации"))
                .andExpect(jsonPath("$.data.documentNumber").value("1234567890"))
                .andExpect(jsonPath("$.data.documentDate").value("2015-12-17"))
                .andExpect(jsonPath("$.data.citizenshipName").value("Spain"))
                .andExpect(jsonPath("$.data.citizenshipCode").value("007"))
                .andExpect(jsonPath("$.data.isIdentified").value(TRUE));
    }

    @Test
    public void getUsersByOffice() throws Exception {
        UserFilter user = new UserFilter();
        user.firstName = "John";
        user.secondName = "Smith";
        user.middleName = "JS";
        user.position = "Worker";
        user.officeId = 1L;
        user.documentCode = "21";
        user.citizenshipCode = "007";
        mockMvc.perform(
                post("/api/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data..id").value(1))
                .andExpect(jsonPath("$.data..firstName").value("John"))
                .andExpect(jsonPath("$.data..secondName").value("Smith"))
                .andExpect(jsonPath("$.data..middleName").value("JS"))
                .andExpect(jsonPath("$.data..position").value("Worker"));
    }

    @Test
    public void saveUser() throws Exception {
        UserViewSave user = new UserViewSave();
        user.officeId = 1L;
        user.firstName = "Joe";
        user.secondName = "Smi";
        user.middleName = "JS";
        user.position = "Workerrr";
        user.phone = "798456";
        user.docCode = "21";
        user.docName = "Паспорт гражданина Российской Федерации";
        user.docNumber = "777555888";

        String date = "2015-12-17";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        user.docDate = formatter.parse(date);
        user.citizenshipCode = "007";
        user.isIdentified = TRUE;

        mockMvc.perform(
                post("/api/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/user/4")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(4))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.firstName").value(user.firstName))
                .andExpect(jsonPath("$.data.secondName").value(user.secondName))
                .andExpect(jsonPath("$.data.middleName").value(user.middleName))
                .andExpect(jsonPath("$.data.position").value(user.position))
                .andExpect(jsonPath("$.data.phone").value(user.phone))
                .andExpect(jsonPath("$.data.documentName").value(user.docName))
                .andExpect(jsonPath("$.data.documentNumber").value(user.docNumber))
                .andExpect(jsonPath("$.data.documentDate").value("2015-12-17"))
                .andExpect(jsonPath("$.data.citizenshipName").value("Spain"))
                .andExpect(jsonPath("$.data.citizenshipCode").value(user.citizenshipCode))
                .andExpect(jsonPath("$.data.isIdentified").value(TRUE));
    }

    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(
                get("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.firstName").value("John"))
                .andExpect(jsonPath("$.data.secondName").value("Smith"))
                .andExpect(jsonPath("$.data.middleName").value("JS"))
                .andExpect(jsonPath("$.data.position").value("Worker"))
                .andExpect(jsonPath("$.data.phone").value("5551100"))
                .andExpect(jsonPath("$.data.documentName").value("Паспорт гражданина Российской Федерации"))
                .andExpect(jsonPath("$.data.documentNumber").value("1234567890"))
                .andExpect(jsonPath("$.data.documentDate").value("2015-12-17"))
                .andExpect(jsonPath("$.data.citizenshipName").value("Spain"))
                .andExpect(jsonPath("$.data.citizenshipCode").value("007"))
                .andExpect(jsonPath("$.data.isIdentified").value(TRUE));

        UserViewUpdate user = new UserViewUpdate();
        user.id = 1L;
        user.officeId = 1L;
        user.firstName = "Joe";
        user.secondName = "Smi";
        user.middleName = "JS";
        user.position = "Workerrr";
        user.phone = "798456";
        user.docName = "Паспорт гражданина Российской Федерации";
        user.docNumber = "777555888";
        String date = "2015-12-17";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        user.docDate = formatter.parse(date);
        user.citizenshipCode = "007";
        user.isIdentified = TRUE;

        mockMvc.perform(
                post("/api/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.firstName").value(user.firstName))
                .andExpect(jsonPath("$.data.secondName").value(user.secondName))
                .andExpect(jsonPath("$.data.middleName").value(user.middleName))
                .andExpect(jsonPath("$.data.position").value(user.position))
                .andExpect(jsonPath("$.data.phone").value(user.phone))
                .andExpect(jsonPath("$.data.documentName").value(user.docName))
                .andExpect(jsonPath("$.data.documentNumber").value(user.docNumber))
                .andExpect(jsonPath("$.data.documentDate").value("2015-12-17"))
                .andExpect(jsonPath("$.data.citizenshipName").value("Spain"))
                .andExpect(jsonPath("$.data.citizenshipCode").value(user.citizenshipCode))
                .andExpect(jsonPath("$.data.isIdentified").value(TRUE));
    }
}