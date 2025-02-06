package com.example.utenti.controllers;

import com.example.utenti.dto.requests.CreateUtenteRequest;
import com.example.utenti.dto.requests.UpdateUtenteRequest;
import com.example.utenti.dto.responses.EntityIdResponse;
import com.example.utenti.dto.responses.GenericResponse;
import com.example.utenti.dto.responses.UtenteResponse;
import com.example.utenti.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utenti")

public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UtenteResponse> getUtenteById(@PathVariable Long id){
        return new ResponseEntity<>(utenteService.getUtenteProfiloById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UtenteResponse>> getAllUtenti(){
        return new ResponseEntity<>(utenteService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<EntityIdResponse> insertUtente(@RequestBody CreateUtenteRequest request){
        return new ResponseEntity<>(utenteService.createUtente(request), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<EntityIdResponse> insertUtente(@RequestBody UpdateUtenteRequest request, @PathVariable Long id){
        return new ResponseEntity<>(utenteService.udpateById(request,id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteUtenteById(@PathVariable Long id){
        return new ResponseEntity<>(utenteService.deleteById(id), HttpStatus.OK);
    }


}
