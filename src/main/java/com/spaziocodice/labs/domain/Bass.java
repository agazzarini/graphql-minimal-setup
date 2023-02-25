package com.spaziocodice.labs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This should be a JPA Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bass {
    private int id;
    protected String brand;
    protected String model;
    private boolean fretless;
    private int strings;

    public Bass(String brand, String model, int id, boolean fretless, int strings) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fretless = fretless;
        this.strings = strings;
    }
}
