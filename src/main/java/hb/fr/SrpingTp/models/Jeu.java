package hb.fr.SrpingTp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private int nombreJoueursMin;
    private int nombreJoueursMax;
    private int duree;
    private int year;

    @OneToMany(mappedBy = "jeu", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Edition> editions = new ArrayList<>();

    @ManyToOne
    @JsonIgnoreProperties({"jeux"})
    private Categorie categorie;

    @ManyToMany(mappedBy = "jeux")
    @JsonIgnore
    private List<Joueur> joueurs = new ArrayList<>();

    public Jeu(Long id, String nom, String description, int nombreJoueursMin, int nombreJoueursMax, int duree, int year, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.nombreJoueursMin = nombreJoueursMin;
        this.nombreJoueursMax = nombreJoueursMax;
        this.duree = duree;
        this.year = year;
        this.categorie = categorie;
    }

    public Jeu(String nom, String description, int nombreJoueursMin, int nombreJoueursMax, int duree, int year, Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.nombreJoueursMin = nombreJoueursMin;
        this.nombreJoueursMax = nombreJoueursMax;
        this.duree = duree;
        this.year = year;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Jeu{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", nombreJoueursMin=" + nombreJoueursMin +
                ", nombreJoueursMax=" + nombreJoueursMax +
                ", duree=" + duree +
                ", year=" + year +
               // ", editions=" + editions +
                ", categorie=" + categorie +
               // ", joueurs=" + joueurs +
                '}';
    }
}
