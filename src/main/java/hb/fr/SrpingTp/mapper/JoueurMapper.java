package hb.fr.SrpingTp.mapper;

import hb.fr.SrpingTp.dto.JoueurDto;
import hb.fr.SrpingTp.models.Joueur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JoueurMapper {

    JoueurDto toDo(Joueur joueur);

    Joueur toEntity(JoueurDto joueurDto);
}
