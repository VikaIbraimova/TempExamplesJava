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
import ru.test.service.AutoService;

@RequestMapping(value = {"/", "/autos"})
@Controller
public class AutoController {
    final Logger logger = LoggerFactory.getLogger(AutoController.class);

    @Autowired
    private AutoService autoService;

    @RequestMapping(method=RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> contacts = autoService.findAll();
        uiModel.addAttribute("autos", contacts);

        logger.info("No. of autos: " + contacts.size());

        return "autos/list";
    }
}
