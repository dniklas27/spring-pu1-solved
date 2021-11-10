package de.navix.zinsrechner.services;

import de.navix.zinsrechner.models.ZinsZeile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZinsService {
    public List<ZinsZeile> getZinszeilenForAllYears(double startCapital, double interest, int duration) {
        List<ZinsZeile> zinsZeilen = new ArrayList<>();

        double interestPercentage = interest / 100;

        double currentCapital = startCapital;

        for (int year = 1; year <= duration; year++) {
            double currentInterest = currentCapital * interestPercentage;
            double currentEndCapital = currentCapital + currentInterest;

            ZinsZeile zinsZeile = new ZinsZeile(year, currentCapital, currentInterest, currentEndCapital);
            zinsZeilen.add(zinsZeile);

            currentCapital = currentEndCapital;
        }

        return zinsZeilen;
    }
}
