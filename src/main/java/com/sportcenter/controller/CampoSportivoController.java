package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.model.CampoSportivo;
import com.sportcenter.repository.CampoSportivoRepository;

@RestController
@RequestMapping("/api/campi")
public class CampoSportivoController {

    @Autowired
    private CampoSportivoRepository repository;

    @GetMapping
    public List<CampoSportivo> findAll()  {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CampoSportivo find(@PathVariable Long id)  {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public CampoSportivo create(@RequestBody CampoSportivo campoSportivo)  {
        return repository.save(campoSportivo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)  {
        repository.deleteById(id);
    }
}
