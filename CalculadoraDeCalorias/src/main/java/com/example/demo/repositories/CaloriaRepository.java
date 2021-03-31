package com.example.demo.repositories;

import com.example.demo.dto.CaloriaDTO;
import com.example.demo.exceptionHandler.NotFoundIngredientException;

public interface CaloriaRepository {

    CaloriaDTO findCaloriesByName(String name) throws NotFoundIngredientException;
}
