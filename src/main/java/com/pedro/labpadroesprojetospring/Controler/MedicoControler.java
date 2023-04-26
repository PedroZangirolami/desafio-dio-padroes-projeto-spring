package com.pedro.labpadroesprojetospring.Controler;

import com.pedro.labpadroesprojetospring.Model.Medico;
import com.pedro.labpadroesprojetospring.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico")
public class MedicoControler {
    @Autowired
    MedicoService medicoService;

    @GetMapping
    public ResponseEntity<Iterable<Medico>> buscarTodos() {
        return ResponseEntity.ok(medicoService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Medico> inserir(@RequestBody Medico medico) {
        medicoService.inserir(medico);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizar(@PathVariable Long id, @RequestBody Medico medico) {
        medicoService.atualizar(id, medico);
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
