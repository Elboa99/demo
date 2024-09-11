package controllers;

import entities.Autore;
import exceptions.NotFoundException;
import Services.AutoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    AutoreService autoreService;

    // 1. - POST http://localhost:3002/autori (+ req.body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Autore saveAutore(@RequestBody Autore body) {
        return autoreService.save(body);
    }

    // 2. - GET http://localhost:3002/autori
    @GetMapping("")
    public List<Autore> getAutori() {
        return autoreService.getAutori();
    }

    // 3. - GET http://localhost:3002/autori/{autoreId}
    @GetMapping("/{autoreId}")
    public Autore findById(@PathVariable int autoreId) {
        return autoreService.findById(autoreId);
    }

    // 4. - PUT http://localhost:3002/autori/{autoreId} (+ req.body)
    @PutMapping("/{autoreId}")
    public Autore findAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return autoreService.findByIdAndUpdate(autoreId, body);
    }

    // 5. - DELETE http://localhost:3002/autori/{autoreId}
    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int autoreId) {
        autoreService.findByIdAndDelete(autoreId);
    }
}
