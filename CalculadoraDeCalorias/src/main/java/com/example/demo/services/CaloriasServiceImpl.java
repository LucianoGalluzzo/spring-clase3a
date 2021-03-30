package com.example.demo.services;

import com.example.demo.dto.IngredienteDTO;
import com.example.demo.dto.PlatoDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.repositories.CaloriaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriasServiceImpl implements CaloriasService{

    private CaloriaRepository caloriaRepository;

    public CaloriasServiceImpl(CaloriaRepository caloriaRepository){
        this.caloriaRepository = caloriaRepository;
    }

    @Override
    public ResponseDTO obtenerCalorias(PlatoDTO plato) {
        double resultado=0, max=0, aux=0;
        IngredienteDTO ingMax = null;
        List<IngredienteDTO> list = new ArrayList<>();
        for(IngredienteDTO ingrediente: plato.getIngredientes()) {
            aux=caloriaRepository.findCaloriesByName(ingrediente.getNombre()).getCalories()
                    * ingrediente.getPeso() / 100;
            resultado += aux;
            if(aux > max){
                max = aux;
                ingMax = ingrediente;
            }
            list.add(new IngredienteDTO(ingrediente.getNombre(), ingrediente.getPeso(), aux));

        }
        ingMax.setCalorias(max);
        return new ResponseDTO(resultado, list, ingMax);
    }

    @Override
    public List<ResponseDTO> obtenerCaloriasPorPlato(List<PlatoDTO> platos) {
        List<ResponseDTO> list = new ArrayList<>();
        for(PlatoDTO p: platos){
            list.add(obtenerCalorias(p));
        }
        return list;
    }


}
