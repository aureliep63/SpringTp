package hb.fr.SrpingTp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditionDto {

    Long id;
    private int anneeEdition;
    private  String langue;
    private  Long jeuId;
    private  Long editeurId;
}
