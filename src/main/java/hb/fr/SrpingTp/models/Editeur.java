package hb.fr.SrpingTp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'éditeur est obligatoire.")
    @Size(min = 2, max = 50, message = "Le nom de l'éditeur doit avoir entre 3 et 50 caractères.")
    private String nom;

    @NotBlank(message = "L'adresse de l'éditeur est obligatoire.")
    private String adresse;

    @URL(message = "L'URL du site web n'est pas valide.")
    private String siteWeb;

    @OneToMany(mappedBy = "editeur")
    @JsonIgnore
    private List<Edition> editions = new ArrayList<>();

    @Override
    public String toString() {
        return "Editeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
               // ", editions=" + editions +
                '}';
    }
}
