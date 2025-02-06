package com.example.utenti.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UpdateUtenteRequest
        (
        @Size(max = 30, message = "La lunghezza massima di un nome è 30 caratteri")
        String nome,

        @Size(max = 30, message = "La lunghezza massima di un cognome è 30 caratteri")
        String cognome,

        @Past(message = "La data di nascita non può essere nel futuro")
        LocalDate dataNascita,

        @Email(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$", message = "Formato password non valido: almeno 8 caratteri, 1 maiuscola, 1 numero, 1 carattere speciale")
        String email
        )
{

}
