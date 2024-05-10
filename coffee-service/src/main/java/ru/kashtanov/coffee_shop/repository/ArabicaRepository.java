package ru.kashtanov.coffee_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kashtanov.coffee_shop.model.Arabica;
@Repository
public interface ArabicaRepository extends JpaRepository<Arabica,Integer> {
}
