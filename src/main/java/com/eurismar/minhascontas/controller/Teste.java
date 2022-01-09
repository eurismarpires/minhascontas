package com.eurismar.minhascontas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Teste {

    @RequestMapping("/")
    @ResponseBody
    public String Ola() {
        return "Olá bem vindo, tudo bem!";
    }
}
