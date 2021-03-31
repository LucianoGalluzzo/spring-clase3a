package com.example.demo.exceptionHandler;

public class NotFoundIngredientException extends Exception{

    public NotFoundIngredientException(String element){
        super("Ingredient: " + element + " not found in database");
    }
}
