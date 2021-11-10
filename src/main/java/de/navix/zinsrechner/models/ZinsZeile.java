package de.navix.zinsrechner.models;

public record ZinsZeile (
    int year,
    double startCapital,
    double totalInterest,
    double endCapital
) {
    public ZinsZeile(int year, double startCapital, double totalInterest, double endCapital) {
        this.year = year;
        this.startCapital = Math.round(startCapital * 100) / 100D;
        this.totalInterest = Math.round(totalInterest * 100) / 100D;
        this.endCapital = Math.round(endCapital * 100) / 100D;
    }
}
