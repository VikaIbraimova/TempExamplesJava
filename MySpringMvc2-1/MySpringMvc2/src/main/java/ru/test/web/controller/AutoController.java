package ru.test.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.test.model.Auto;
import ru.test.service.AutoService;

//@RequestMapping(value = {"/", "/autos"})
@Controller
public class AutoController {
    final Logger logger = LoggerFactory.getLogger(AutoController.class);

    @Autowired
    private AutoService autoService;

    /*@RequestMapping("/")
    public String home() {
        //return "redirect:/home";
        return "/home";
    }*/

    //@RequestMapping(method=RequestMethod.GET)
    @RequestMapping(value = "autos", method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> contacts = autoService.findAll();
        uiModel.addAttribute("autos", contacts);

        logger.info("No. of autos: " + contacts.size());

        return "autos/list";
    }

    @RequestMapping(value = "autos3", method = RequestMethod.GET)
    public String list3(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> contacts = autoService.findAll();
        uiModel.addAttribute("autos", contacts);

        logger.info("No. of autos: " + contacts.size());

        return "autos/list3";
    }

    /*@RequestMapping(value = "/pathvariable/{name}/{auto}")
    public String pathVariable(@PathVariable String markaName, @PathVariable("name") String name, Model model) {
        List<Auto> contacts2 = autoService.getByName(markaName);
        model.addAttribute("autos", markaName);

        return "autos/list4";
    }*/
}
