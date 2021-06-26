package com.cng457.Project.controller;

import com.cng457.Project.entity.Phone;
import com.cng457.Project.service.PhoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class PhoneControllerTest {

    @InjectMocks
    PhoneController phoneController;   // No need to use

    @Mock
    PhoneService phoneService; // No need to use

    @LocalServerPort
    private int port; // No need to use

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();

   /* @Test                     // We reall do not need this
    void getPhoneBrands() {
        Phone std1 = new Phone();
        Phone std2 = new Phone();
        List<Phone> phones = new ArrayList<>();
        phones.add(std1);
        phones.add(std2);

        when(phoneService.getAllPhones()).thenReturn(new ArrayList(phones));

        List<Phone> phoneList = phoneController.getAllPhones();
        Assertions.assertEquals(phones.size()+1, phoneList.size());
        Assertions.assertEquals("Test", phoneList.get(phoneList.size()-1).getBrand());
    }*/

    @Test
    void getPhoneModel() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getAllPhones", Phone[].class)[0].getModel().equals("phone1"));
    }

    @Test
    void getPhonePriceWithId() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getPhone/1", Phone.class).getPrice() == 3200);
    }

    @Test
    void getPhoneBrandWithId() {
        assertTrue(
                this.restTemplate.getForObject("http://localhost:8080/getPhone/1", Phone.class).getBrand().getBrandName().equals("testBrand1"));

    }

}
