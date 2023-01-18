package Gestion.etudiant.Crud_Etudiant.repository;

import Gestion.etudiant.Crud_Etudiant.model.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long> {
}
