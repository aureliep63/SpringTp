package hb.fr.SrpingTp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurDto  {

    Long id;
    private   String nom;
    private String prenom;
    private String email;
}
