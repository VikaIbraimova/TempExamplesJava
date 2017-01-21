package ru.itsphere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    @Controller - аннотация, которая показывает, что данный класс
	является контроллером (принимает запросы с браузера(клиента)).
	Также данная аннотация показывает, что данный класс является bean-ом
	и его жизненый цикл управляется spring IoC контейнером.
 */
@Controller
/*
	@RequestMapping("/") - аннотация, которая задает шаблон того
	какие запросы этот контроллер будет обрабатывать.
	"/" - означает, что все запросы будут обращены на этот контроллер.
	Если так "/login" - запросы вида "http://localhost:8080/login",
	"http://localhost:8080/login?pass=?" будут обработаны этим контроллером.
 */
@RequestMapping("/")
public class HelloController {

    /*
        Данная аннотация может быть применена и к методам.
        Одним из параметров, которые можно указать является
        тип http запроса (GET, POST, PUT и т.д.).
        Шаблон URL и тип метода можно комбинировать.
        Данный метод принимает запросы типа GET.
    */
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
		/*
			ModelMap - реализация интерфейса Map. Данный объект
			предназначен для передачи информации на JSP страницу.
			В данном случае на страницу hello.jsp будет передана
			переменная message со значение "Рello world".
		*/
        model.addAttribute("message", "Hello world!");

		/*
			Возвращаемым значением мы указали страницу jsp,
			на которую передается "message" и она откроется в браузере.
		*/
        return "hello";
    }
}
