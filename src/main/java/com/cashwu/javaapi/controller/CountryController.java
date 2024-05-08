package com.cashwu.javaapi.controller;

import com.cashwu.javaapi.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {

        Country country = Country.of("france", 67);

        ResponseEntity<Country> responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED)
                                                     .header("continent", "Europe")
                                                     .header("capital", "Paris")
                                                     .body(country);

        return responseEntity;
    }

    @GetMapping("/list")
    public List<Country> list() {

        Country france = Country.of("france", 67);
        Country spain = Country.of("spain", 47);
        return List.of(france, spain);
    }

}
