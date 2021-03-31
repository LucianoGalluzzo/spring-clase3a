package com.example.demo.repositories;

import com.example.demo.dto.CaloriaDTO;
import com.example.demo.exceptionHandler.NotFoundIngredientException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriaRepositoryImpl implements CaloriaRepository {


    @Override
    public CaloriaDTO findCaloriesByName(String name) throws NotFoundIngredientException {
        List<CaloriaDTO> caloriaDTOs = null;
        caloriaDTOs = loadDataBase();
        CaloriaDTO result = null;
        if (caloriaDTOs != null){
            Optional<CaloriaDTO> item = caloriaDTOs.stream()
                    .filter(caloriaDTO -> caloriaDTO.getName().equals(name))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
            else{
                throw new NotFoundIngredientException(name);
            }
        }

        return result;
    }

    private List<CaloriaDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CaloriaDTO>> typeRef = new TypeReference<List<CaloriaDTO>>() {};
        List<CaloriaDTO> caloriaDTOs = null;

        try {
            caloriaDTOs = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return caloriaDTOs;

    }
}
