package hb.fr.SrpingTp.mapper;

import hb.fr.SrpingTp.dto.CategorieDto;
import hb.fr.SrpingTp.models.Categorie;
import hb.fr.SrpingTp.models.Jeu;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategorieMapper {

    Categorie toEntity(CategorieDto categorieDto);

    @Mapping(target = "jeuxId", source = "jeux")
    CategorieDto toDto(Categorie categorie);
    List<Long> map(List<Jeu> jeux);
    default Long map(Jeu jeu){
        return jeu != null ? jeu.getId() : null;
    }
}
