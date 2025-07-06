package hb.fr.SrpingTp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la catégorie est obligatoire.")
    @Size(min = 2, max = 50, message = "Le nom de l'éditeur doit avoir entre 2 et 50 caractères.")
    private String nom;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Jeu> jeux = new ArrayList<>();

    public Categorie(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Categorie(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                //", jeux=" + jeux +
                '}';
    }
}
