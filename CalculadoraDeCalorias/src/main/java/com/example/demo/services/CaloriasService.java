package com.example.demo.services;


import com.example.demo.dto.PlatoDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exceptionHandler.NotFoundIngredientException;

import java.util.List;

public interface CaloriasService {

    ResponseDTO obtenerCalorias(PlatoDTO plato) throws NotFoundIngredientException;
    List<ResponseDTO> obtenerCaloriasPorPlato(List<PlatoDTO> platos) throws NotFoundIngredientException;
}
