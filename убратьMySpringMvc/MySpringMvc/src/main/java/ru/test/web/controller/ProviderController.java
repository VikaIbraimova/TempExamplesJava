package ru.test.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.model.Auto;
import ru.test.service.ProviderService;


@RequestMapping(value = {"/", "/autos"})
@Controller
public class ProviderController {
    final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private ProviderService providerService;

    @RequestMapping(method=RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> contacts = providerService.findAll();
        uiModel.addAttribute("autosalon", contacts);

        logger.info("No. of autosalons: " + contacts.size());

        return "autosalon/list";
    }
}