package hb.fr.SrpingTp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDto  {
    Long id;
    private  String nom;
    private List<Long> jeuxId;
}
