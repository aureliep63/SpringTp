package hb.fr.SrpingTp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du joueur est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prénom du joueur est obligatoire.")
    private String prenom;

    @NotBlank(message = "L'email du joueur est obligatoire.")
    @Email(message = "L'adresse e-mail n'est pas valide.")
    private String email;

    private LocalDate dateInscription;

    @ManyToMany
    @JoinTable(
            name = "joueur_jeu", // nom de la table d'association
            joinColumns = @JoinColumn(name = "joueur_id"), // Clé étrangère pour la table Etudiant
            inverseJoinColumns = @JoinColumn(name = "jeu_id") // Clé étrangère pour la table Cours
    )
    private List<Jeu> jeux = new ArrayList<>();;

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dateInscription=" + dateInscription +
              //  ", jeux=" + jeux +
                '}';
    }
}
