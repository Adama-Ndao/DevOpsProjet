package Gestion.etudiant.Crud_Etudiant.controller;


import Gestion.etudiant.Crud_Etudiant.exception.ResourceNotFoundException;
import Gestion.etudiant.Crud_Etudiant.model.Etudiant;
import Gestion.etudiant.Crud_Etudiant.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiant")
    public List<Etudiant> getAllEtudiant(){
        return etudiantRepository.findAll();
    }
    @PostMapping("/etudiant")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    @GetMapping("/etudiant/{id}")
    public ResponseEntity <Etudiant> getEtudiantById(Long id){
        Etudiant etudiant = etudiantRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Etuadiant not exist with id :"+id));
        return ResponseEntity.ok(etudiant);
    }
    @PutMapping("/etudiant/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails){
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Etuadiant not exist with id :"+id));

        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setEmail_id(etudiantDetails.getEmail_id());

        Etudiant updatedEtudiant  = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }
}
