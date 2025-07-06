package hb.fr.SrpingTp.mapper;

import hb.fr.SrpingTp.dto.EditeurDto;
import hb.fr.SrpingTp.dto.EditionDto;
import hb.fr.SrpingTp.models.Editeur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EditeurMapper {

    EditeurDto toDo(Editeur editeur);

    Editeur toEntity(EditeurDto editeurDto);
}
