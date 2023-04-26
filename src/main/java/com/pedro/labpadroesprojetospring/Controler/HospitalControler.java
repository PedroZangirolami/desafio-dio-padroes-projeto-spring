package com.pedro.labpadroesprojetospring.Controler;

import com.pedro.labpadroesprojetospring.Model.Hospital;
import com.pedro.labpadroesprojetospring.Model.Medico;
import com.pedro.labpadroesprojetospring.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital")
public class HospitalControler {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<Iterable<Hospital>> buscarTodos() {
        return ResponseEntity.ok(hospitalService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.buscarPorId(id));
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Iterable<Medico>> buscarTodosMedicos(@PathVariable Long id){
        return ResponseEntity.ok(hospitalService.buscarMedicos(id));
    }

    @PostMapping
    public ResponseEntity<Hospital> inserir(@RequestBody Hospital hospital) {
        hospitalService.inserir(hospital);
        return ResponseEntity.ok(hospital);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hospital> atualizar(@PathVariable Long id, @RequestBody Hospital hospital) {
        hospitalService.atualizar(id, hospital);
        return ResponseEntity.ok(hospital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        hospitalService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
