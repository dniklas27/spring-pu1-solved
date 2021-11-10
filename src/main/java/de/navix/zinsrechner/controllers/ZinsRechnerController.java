package de.navix.zinsrechner.controllers;

import de.navix.zinsrechner.models.ZinsForm;
import de.navix.zinsrechner.models.ZinsZeile;
import de.navix.zinsrechner.services.ZinsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ZinsRechnerController {
    private ZinsService zinsService;

    public ZinsRechnerController(ZinsService zinsService) {
        this.zinsService = zinsService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        ZinsForm zinsForm = new ZinsForm(null, null, null, false);
        model.addAttribute("zinsForm", zinsForm);

        return "show_form";
    }

    @PostMapping("/")
    public String handleForm(Model model, ZinsForm form) {
        List<ZinsZeile> zinsZeilen = zinsService.getZinszeilenForAllYears(
                form.startCapital(),
                form.interest(),
                form.duration()
        );

        ZinsZeile lastZinsZeile = zinsZeilen.get(zinsZeilen.size() - 1);
        double endCapital = lastZinsZeile.endCapital();

        model.addAttribute("endCapital", endCapital);
        model.addAttribute("zinsZeilen", zinsZeilen);

        return "show_form";
    }

}
