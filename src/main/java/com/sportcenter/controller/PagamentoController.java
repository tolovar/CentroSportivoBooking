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

import com.sportcenter.model.Pagamento;
import com.sportcenter.repository.PagamentoRepository;

@RequestMapping("/api/pagamenti")
@RestController
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository repository;

    @GetMapping
    public List<Pagamento> findAll()  {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento find(@PathVariable Long id)  {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento)  {
        return repository.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)  {
        repository.deleteById(id);
    }

}
