package Gestion.etudiant.Crud_Etudiant.controller;

import Gestion.etudiant.Crud_Etudiant.exception.ResourceNotFoundException;
import Gestion.etudiant.Crud_Etudiant.model.Sujet;
import Gestion.etudiant.Crud_Etudiant.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class SujetController {
    @Autowired
    private SujetRepository sujetRepository;
    @GetMapping("/sujet")
    public List<Sujet> getAllSujet(){
        return sujetRepository.findAll();
    }
    @PostMapping("/sujet")
    public Sujet createSujet(@RequestBody Sujet sujet){
        return sujetRepository.save(sujet);
    }
    @GetMapping("/sujet/{id}")
    public ResponseEntity<Sujet> getSujetById(@PathVariable Long id){
        Sujet sujet = sujetRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Sujet not exist with id :"+id));
        return ResponseEntity.ok(sujet);
    }

}
