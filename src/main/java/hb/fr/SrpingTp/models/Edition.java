package hb.fr.SrpingTp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "L'année d'édition est obligatoire.")
    @Min(value = 1900, message = "L'année d'édition doit être au minimum 1900.")
    @Max(value = 2024, message = "L'année d'édition doit être au maximum l'année en cours.")
    private int anneeEdition;

    @NotNull(message = "Le choix de la langue est obligatoire.")
    @Pattern(
            regexp = "^[a-zA-ZÀ-ÿ'-]+$",
            message = "La langue ne peut contenir que des lettres, des tirets et des apostrophes."
    )
    private String langue;

    @NotNull(message = "Le jeu ne peut pas être nul.")
    @ManyToOne(cascade = CascadeType.ALL)
    private Jeu jeu;

    @ManyToOne
    private Editeur editeur;

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", anneeEdition=" + anneeEdition +
                ", langue='" + langue + '\'' +
                ", jeu=" + jeu +
                ", editeur=" + editeur +
                '}';
    }
}
