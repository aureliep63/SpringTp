package hb.fr.SrpingTp.services.impl;

import hb.fr.SrpingTp.dto.EditionDto;
import hb.fr.SrpingTp.mapper.EditionMapper;
import hb.fr.SrpingTp.models.Editeur;
import hb.fr.SrpingTp.models.Edition;
import hb.fr.SrpingTp.models.Jeu;
import hb.fr.SrpingTp.repository.EditeurRepository;
import hb.fr.SrpingTp.repository.EditionRepository;
import hb.fr.SrpingTp.repository.JeuRepository;
import hb.fr.SrpingTp.services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditionServiceImpl implements EditionService {

    @Autowired
    EditionMapper editionMapper;

    private EditionRepository editionRepository;

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private EditeurRepository editeurRepository;

    // constructeur
    public EditionServiceImpl(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }


    @Override
    public List<EditionDto> getAllEditions() {
        // récupère la lite des entités et on les convertis en dto
        List<Edition> editions = editionRepository.findAll();
        return editions.stream()
                        .map(editionMapper::toDto) // Utilise le mapper pour convertir chaque entité en DTO
                        .collect(Collectors.toList());
    }


    @Override
    public EditionDto getEditionById(Long id) {
        return editionRepository.findById(id)
                .map(editionMapper::toDto) // Convertir l'entité en DTO s'il existe
                .orElse(null); // Ou gérer autrement l'absence du jeu
    }


//    @Override
//    public Edition saveEdition(EditionDto editionDto) {
//        Edition edition = editionMapper.toEntity(editionDto);
//
//        if(editionDto.getEditeurId() != null) {
//            Editeur editeur = editeurRepository.findById(editionDto.getEditeurId()).orElse(null);
//            edition.setEditeur(editeur);
//        }
//
//        if(editionDto.getJeuId()!= null) {
//            Jeu jeu = jeuRepository.findById(editionDto.getJeuId()).orElse(null);
//            edition.setJeu(jeu);
//        }
//        return editionRepository.save(edition);
//    }



    @Override
    public void deleteEdition(Long id) {
        editionRepository.deleteById(id);
    }
}
