package ru.kashtanov.coffee_shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.kashtanov.coffee_shop.dto.ArabicaDtoRequest;
import ru.kashtanov.coffee_shop.dto.ArabicaDtoResponse;
import ru.kashtanov.coffee_shop.model.Arabica;
import ru.kashtanov.coffee_shop.repository.ArabicaRepository;

import java.util.List;

@Service
public class ArabicaService {
    private final ArabicaRepository arabicaRepository;
    private static final Logger logInfo = LoggerFactory.getLogger(Arabica.class);

    public ArabicaService(ArabicaRepository arabicaRepository) {
        this.arabicaRepository = arabicaRepository;
    }

    public List<ArabicaDtoResponse> getAllArabicaCoffee() {
        logInfo.info("Whole arabica's list is gotten");
        logInfo.debug("DEBUG IS AVAILABLE");
        List<Arabica>arabicaList = arabicaRepository.findAll();
        List<ArabicaDtoResponse> arabicaDtoResponses = arabicaList.stream().map(arabica->mapToArabicaDtoResponse(arabica)).toList();
        return arabicaDtoResponses;
    }

    private ArabicaDtoResponse mapToArabicaDtoResponse(Arabica arabica) {
          ArabicaDtoResponse arabicaDtoResponse = new ArabicaDtoResponse();
          arabicaDtoResponse.setCoffeeId(arabica.getCoffeeId());
          arabicaDtoResponse.setCoffeeName(arabica.getCoffeeName());
          arabicaDtoResponse.setWeight(arabica.getWeight());
          return arabicaDtoResponse;
    }

    public void addNewArabicaToDb(ArabicaDtoRequest arabicaDto) {
        Arabica arabica = new Arabica();
        arabica.setCoffeeName(arabicaDto.getCoffeeName());
        arabica.setCoffeeWeight(arabicaDto.getWeight());
        arabicaRepository.save(arabica);
        logInfo.info("Arabica " + arabica.getCoffeeId() + " is saved");
    }

    public void deleteChosenCoffee(Integer coffeeId) {
        arabicaRepository.deleteById(coffeeId);
    }

    public Arabica findArabicaById(Integer arabicaId) {
        return arabicaRepository.findById(arabicaId).orElseThrow();
    }

    public void updateArabicaById(Integer arabicaId, ArabicaDtoRequest gottenArabica) {
        Arabica arabica = arabicaRepository.findById(arabicaId).orElseThrow();
        arabica.setCoffeeName(gottenArabica.getCoffeeName());
        arabica.setCoffeeWeight(gottenArabica.getWeight());
        arabicaRepository.save(arabica);
    }
}
