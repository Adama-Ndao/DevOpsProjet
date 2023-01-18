package Gestion.etudiant.Crud_Etudiant.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    public Sujet() {
    }

    public Sujet(String nom) {
        super();
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
