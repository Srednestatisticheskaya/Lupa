package com.example.Joke.Controller;

import com.example.Joke.model.Db_Pupa_I_Lupa;
import com.example.Joke.service.PupaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jokes")
public class Lupa_I_Pupa {

    private final PupaService service;

    @PostMapping
    ResponseEntity<Void> addjoke(@RequestBody Db_Pupa_I_Lupa text) {
        service.addjoke(text);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<Db_Pupa_I_Lupa>> showAllJokes() {
        return ResponseEntity.ok(service.getAllJokes());
    }

    @GetMapping("/{id}")
    ResponseEntity<Db_Pupa_I_Lupa> showjokebyid(@PathVariable Long id) {
        return service.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deletejokebyid(@PathVariable Long id) {
        return service.deleteJokeById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Db_Pupa_I_Lupa> editjokebyid(@PathVariable Long id, @RequestBody Db_Pupa_I_Lupa text) {
        return service.editJokeById(id, text.getText()).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Long getNumber() {
        return service.getNumberid();
    }
}
