package hb.fr.SrpingTp.mapper;

import hb.fr.SrpingTp.dto.EditionDto;
import hb.fr.SrpingTp.models.Edition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EditionMapper {

    // transformer l'entité Edition en Dto Edition
    Edition toEntity(EditionDto editionDto);

    // transformer le Dto Edition en entité Edition
    EditionDto toDto(Edition edition);


}
