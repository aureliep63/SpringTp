package hb.fr.SrpingTp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JeuDto
{
    Long id;
    private   String nom;
    private  String description;
    private  int nombreJoueursMin;
    private  int nombreJoueursMax;
    private  int duree;
    private  int year;
    private  Long categorieId;
    private List<Long> editionsId;
}
