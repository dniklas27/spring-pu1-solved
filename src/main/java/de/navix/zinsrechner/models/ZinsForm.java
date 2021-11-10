package de.navix.zinsrechner.models;

public record ZinsForm(
        Double startCapital,
        Integer duration,
        Double interest,
        Boolean showTable) {

}
