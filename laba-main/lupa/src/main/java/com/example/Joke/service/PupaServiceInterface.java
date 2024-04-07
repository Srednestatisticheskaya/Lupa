package com.example.Joke.service;

import com.example.Joke.model.Db_Pupa_I_Lupa;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PupaServiceInterface {
    void addjoke(Db_Pupa_I_Lupa Jokes);
    List<Db_Pupa_I_Lupa> getAllJokes();
    Optional<Db_Pupa_I_Lupa> getJokeById(Long id);
    ResponseEntity<String> deleteJokeById(Long id);
    Optional<Db_Pupa_I_Lupa> editJokeById(Long id, String text);
}
