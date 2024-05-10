package ru.kashtanov.coffee_shop.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ru.kashtanov.coffee_shop.dto.ArabicaDtoRequest;
import ru.kashtanov.coffee_shop.dto.ArabicaDtoResponse;
import ru.kashtanov.coffee_shop.model.Arabica;

import ru.kashtanov.coffee_shop.service.ArabicaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffee/arabica")
public class ArabicaController {

    private final ArabicaService arabicaService;

    public ArabicaController(ArabicaService arabicaService) {
        this.arabicaService = arabicaService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ArabicaDtoResponse> getAllArabica(){
        return arabicaService.getAllArabicaCoffee();
    }

    @GetMapping("/single")
    public Arabica getSingleArabica(){
        Arabica coffee = new Arabica();
        coffee.setCoffeeName("Arabic");
        coffee.setCoffeeWeight(2.0);
        return coffee;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewArabica(@RequestBody ArabicaDtoRequest arabicaDto){
        arabicaService.addNewArabicaToDb(arabicaDto);
        return "Arabica is successfully added to DB";
    }

    @DeleteMapping("/delete/{coffeeId}")
    public String deleteCoffee(@PathVariable("coffeeId") Integer coffeeId){
        arabicaService.deleteChosenCoffee(coffeeId);
        return "The chosen coffee is successfully deleted";
    }

    @PutMapping("/update/{coffeeId}")
    public String updateCoffee(@RequestBody ArabicaDtoRequest arabicaDto,@PathVariable("coffeeId")Integer coffeeId){
        arabicaService.updateArabicaById(coffeeId, arabicaDto);
        return "The chosen coffee is successfully updated";
    }
}
