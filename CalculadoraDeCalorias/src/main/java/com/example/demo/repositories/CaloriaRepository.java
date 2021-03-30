package com.example.demo.repositories;

import com.example.demo.dto.CaloriaDTO;

public interface CaloriaRepository {

    CaloriaDTO findCaloriesByName(String name);
}
