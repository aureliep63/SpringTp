package hb.fr.SrpingTp.services;

import hb.fr.SrpingTp.dto.EditionDto;
import hb.fr.SrpingTp.models.Edition;

import java.util.List;

public interface EditionService {

    List<EditionDto> getAllEditions();

    EditionDto getEditionById(Long id);

   // Edition saveEdition(EditionDto editionDto);

    void deleteEdition(Long id);

}

