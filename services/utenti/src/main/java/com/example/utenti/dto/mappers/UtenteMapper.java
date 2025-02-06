package com.example.utenti.dto.mappers;

import com.example.utenti.dto.requests.CreateUtenteRequest;
import com.example.utenti.dto.responses.UtenteResponse;
import com.example.utenti.entities.Indirizzo;
import com.example.utenti.entities.Utente;
import org.springframework.stereotype.Service;

@Service
public class UtenteMapper {

    public Utente fromRequest(CreateUtenteRequest request) {
        return Utente
                .builder()
                .nome(request.nome())
                .cognome(request.cognome())
                .dataNascita(request.dataNascita())
                .email(request.email())
                .build();
    }

    public UtenteResponse toResponse(Utente utente) {
        return UtenteResponse
                .builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .email(utente.getEmail())
                .dataNascita(utente.getDataNascita())
                .indirizziId(utente.getIndirizzi()
                                    .stream()
                                    .map(Indirizzo::getId).toList())
                .build();
    }
}
