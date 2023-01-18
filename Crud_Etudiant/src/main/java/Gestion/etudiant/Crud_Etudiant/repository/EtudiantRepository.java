package Gestion.etudiant.Crud_Etudiant.repository;

import Gestion.etudiant.Crud_Etudiant.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
