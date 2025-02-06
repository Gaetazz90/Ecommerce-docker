package com.example.utenti.services;

import com.example.utenti.dto.mappers.UtenteMapper;
import com.example.utenti.dto.requests.CreateUtenteRequest;
import com.example.utenti.dto.requests.UpdateUtenteRequest;
import com.example.utenti.dto.responses.EntityIdResponse;
import com.example.utenti.dto.responses.GenericResponse;
import com.example.utenti.dto.responses.UtenteResponse;
import com.example.utenti.entities.Utente;
import com.example.utenti.exceptions.UtenteNotFoundException;
import com.example.utenti.repositories.UtenteRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private UtenteMapper utenteMapper;

    public Utente getById(Long id) {
        return utenteRepository.findById(id).orElseThrow(()-> new UtenteNotFoundException(String.format("Utente con id: %d non trovato", id)));
    }

    public UtenteResponse getUtenteProfiloById(Long id){
        Utente utente = utenteRepository.findById(id).orElseThrow(()-> new UtenteNotFoundException(String.format("Utente con id: %d non trovato", id)));
        return utenteMapper.toResponse(utente);
    }

    public List<UtenteResponse> getAll(){
        return utenteRepository.findAll().stream().map(utente -> utenteMapper.toResponse(utente)).toList();
    }

    public EntityIdResponse createUtente(CreateUtenteRequest request){
        Utente newUtente = utenteMapper.fromRequest(request);
        utenteRepository.save(newUtente);
        return EntityIdResponse.builder().id(newUtente.getId()).build();
    }

    public EntityIdResponse udpateById( UpdateUtenteRequest request, Long id){
        Utente utente = getById(id);
        if(request.nome() != null)utente.setNome(request.nome());
        if(request.cognome() != null)utente.setCognome(request.cognome());
        if(request.dataNascita() != null)utente.setDataNascita(request.dataNascita());
        if(request.email() != null)utente.setEmail(request.email());
        utenteRepository.save(utente);
        return EntityIdResponse.builder().id(utente.getId()).build();
    }

    public GenericResponse deleteById(Long id){
        Utente utente = getById(id);
        utenteRepository.deleteById(id);
        return new GenericResponse(String.format("Utente con id: %d cancellato con successo", id));

    }

}
