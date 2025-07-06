package hb.fr.SrpingTp.mapper;

import hb.fr.SrpingTp.dto.JeuDto;
import hb.fr.SrpingTp.models.Edition;
import hb.fr.SrpingTp.models.Jeu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JeuMapper {
    // convertir entité Jeu en Dto jeu
    Jeu toEntity(JeuDto jeuDto);

    //convertir Dto jeu en entité jeu
    @Mapping(target = "editionsId",source = "editions")
    @Mapping(target = "categorieId", source="categorie.id")
    JeuDto toDto(Jeu jeu);

    List<Long> map(List<Edition> editions);

    default Long map(Edition edition){
        return edition != null ? edition.getId() : null;
    }
}
