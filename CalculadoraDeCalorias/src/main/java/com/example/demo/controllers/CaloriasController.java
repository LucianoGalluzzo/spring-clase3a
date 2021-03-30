
package com.example.demo.controllers;

import com.example.demo.dto.PlatoDTO;
import com.example.demo.services.CaloriasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calorias")
public class CaloriasController{

    @Autowired
    private CaloriasServiceImpl caloriasService;

    @PostMapping("/")
    public ResponseEntity obtenerCalorias(@RequestBody PlatoDTO plato){
        return new ResponseEntity(caloriasService.obtenerCalorias(plato), HttpStatus.OK);
    }

    @PostMapping("/lista")
    public ResponseEntity obtenerCaloriasPorPlato(@RequestBody List<PlatoDTO> platos){
        return new ResponseEntity(caloriasService.obtenerCaloriasPorPlato(platos), HttpStatus.OK);
    }
}
