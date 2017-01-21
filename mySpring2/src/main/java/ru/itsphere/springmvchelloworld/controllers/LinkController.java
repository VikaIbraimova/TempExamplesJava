package ru.itsphere.springmvchelloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LinkController {

    public static final String METHOD_NAME_ATTR = "methodName";
    public static final String CONTROLLER_PAGE = "controllerPage";

    @RequestMapping(method = RequestMethod.GET, value = "/first")
    public String firstMethod(ModelMap model) {
        model.addAttribute(METHOD_NAME_ATTR, "First");
        return CONTROLLER_PAGE;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/second")
    public String secondMethod(ModelMap model) {
        model.addAttribute(METHOD_NAME_ATTR, "Second");
        return CONTROLLER_PAGE;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/third")
    public String thirdMethod(ModelMap model) {
        model.addAttribute(METHOD_NAME_ATTR, "Third");
        return CONTROLLER_PAGE;
    }
}