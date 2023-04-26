package com.pedro.labpadroesprojetospring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Medico> medicos = new ArrayList<>();

}
