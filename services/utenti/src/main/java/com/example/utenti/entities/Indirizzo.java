package com.example.utenti.entities;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "indirizzi")

public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String via;

    @Column(nullable = false)
    private String civico;

    @Column(nullable = false)
    private String cap;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Comune comune;

}
