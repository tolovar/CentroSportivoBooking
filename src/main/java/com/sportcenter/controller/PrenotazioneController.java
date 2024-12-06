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

import com.sportcenter.dto.PrenotazioneRequest;
import com.sportcenter.dto.PrenotazioneResponse;
import com.sportcenter.model.Prenotazione;
import com.sportcenter.repository.PrenotazioneRepository;
import com.sportcenter.service.PrenotazioniService;

@RequestMapping("/api/prenotazioni")
@RestController
public class PrenotazioneController {

    
    @Autowired
    private PrenotazioneRepository repository;
    @Autowired
    private PrenotazioniService prenotazioneService;

    @GetMapping
    public List<Prenotazione> findAll()  {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Prenotazione find(@PathVariable Long id)  {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public PrenotazioneResponse create(@RequestBody PrenotazioneRequest prenotazioneRequest)  {
        // logica necessaria per
        // 1. recuperare l'utente dal repository UtenteRepository
        // 2. recuerare il campoSportvio dal repository CampoSportivoRepository
        // 3. settare i valori in un oggetto Prenotazione
        // 4. salvare

        Prenotazione prenotazione = prenotazioneService.create(prenotazioneRequest);

        // 5. trasformo la prenotazione in una prenotazioneResponse e ritorno

        PrenotazioneResponse response = mapToResponse(prenotazione);

        // 6. restituisco l'oggetto appena creato (di tipo PrenotazioneResponse)

        return response;
        //return prenotazioniService.create(prenotazioneRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)  {
        repository.deleteById(id);
    }

    private PrenotazioneResponse mapToResponse(Prenotazione prenotazione) {
        PrenotazioneResponse response = new PrenotazioneResponse();

        response.setId(prenotazione.getId());
        response.setStato(prenotazione.getStato());
        response.setCampoSportivoId(prenotazione.getCampoSportivo().getId());
        response.setUtenteId(prenotazione.getUtente().getId());
        response.setDataOra(prenotazione.getDataOra());
                
        return response;
    }
}
