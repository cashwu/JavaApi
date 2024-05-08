package com.cashwu.javaapi.model;

import lombok.Data;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@Data
public class Country {

    private String name;
    private int code;

    public static Country of(String name,
                             int code) {
        Country country = new Country();
        country.setName(name);
        country.setCode(code);
        return country;
    }
}
