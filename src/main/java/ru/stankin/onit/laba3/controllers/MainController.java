package ru.stankin.onit.laba3.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stankin.onit.laba3.entity.Cat;
import ru.stankin.onit.laba3.servicies.JSONService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class MainController {
    private JSONService jsonService;

    @Autowired
    public MainController(JSONService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping("/home")
    public String index(Model model) throws JsonProcessingException {
        List<Cat> cats = jsonService.getCatFacts();
        model.addAttribute("cats", cats.stream().map(x -> x.toString()).collect(Collectors.toList()));
        return "cats";
    }

//    @GetMapping("/greet")
//    public String greet(@RequestParam(defaultValue = "world") String name) {
//        return "Hello, " + name;
//    }
//
    @GetMapping("/catFacts")
    public String getCatFacts(Model model) throws JsonProcessingException {
        jsonService.getCatFacts();
        model.addAttribute("message", "lolkekchebureck");
        return "index";
    }
//
    @GetMapping("/catOrHorseFacts")
    public String getCatsAndHorseFacts() throws JsonProcessingException {
        jsonService.getCatsAndHorseFacts();
        return "catAndDogs";
    }

    @GetMapping("/getNobelPrize")
    public String getNobelPrize(Model model){
        model.addAttribute("prizes", jsonService.getNobelPrize());
        return "nobelPrizes";
    }

    @GetMapping("/changeStructureJson")
    public String changePublicJson(Model model) {
        jsonService.changeStructure();
        model.addAttribute("prizes", jsonService.getNobelPrize());
        return "nobelPrizes";
    }

//    @GetMapping("/deleteChangeStructureJson")
//    public String deleteChangePublicJson(Model model) {
//        jsonService.deleteChangeStructure();
//        model.addAttribute("prizes", jsonService.getNobelPrize());
//        return "nobelPrizes";
//    }
}
