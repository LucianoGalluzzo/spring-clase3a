package com.example.demo.services;


import com.example.demo.dto.PlatoDTO;
import com.example.demo.dto.ResponseDTO;

public interface CaloriasService {

    ResponseDTO obtenerCalorias(PlatoDTO plato);
}
