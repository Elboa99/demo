package controllers;

import entities.Autore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class BlogControllers {
    // 1. GET http://localhost:3002/blog
    @GetMapping
    private String getAllAutori(){
        return "Ecco tutti i post!";
    }

    // 2. GET http://localhost:3002/blog%7Bblogid%7D
    @GetMapping("/{autoreid}")
    private String getAutoreById(@PathVariable int autoreId){
        return "Ecco il blog creato!";
    }

    // 3. POST http://localhost:3002/(+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String createAutore(@RequestBody Autore body){
        return "Autore creato!";
    }

    // 4. PUT http://localhost:3002/%7Bblogid%7D(+body)
    @PutMapping("/{autoreid}")
    private String findAutoreByIdAndUpdate(@PathVariable int autoreId,@RequestBody Autore body){
        return "Hai modificato l'autore!";
    }


    // 5. DELETE http://localhost:3002/%7Bblogid%7D
    @DeleteMapping("/{autoreid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private String deleteAutore(@PathVariable int autoreId){
        return "Hai eliminato l'autore";
    }
}

