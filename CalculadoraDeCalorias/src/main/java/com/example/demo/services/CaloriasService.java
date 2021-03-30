package com.example.demo.services;


import com.example.demo.dto.PlatoDTO;
import com.example.demo.dto.ResponseDTO;

import java.util.List;

public interface CaloriasService {

    ResponseDTO obtenerCalorias(PlatoDTO plato);
    List<ResponseDTO> obtenerCaloriasPorPlato(List<PlatoDTO> platos);
}
