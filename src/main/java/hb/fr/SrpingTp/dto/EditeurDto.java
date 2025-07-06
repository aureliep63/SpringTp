package hb.fr.SrpingTp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditeurDto {
    Long id;
    private String nom;
    private String adresse;
    private  String siteWeb;

}
