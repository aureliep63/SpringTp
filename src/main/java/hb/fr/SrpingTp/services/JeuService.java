package hb.fr.SrpingTp.services;

import hb.fr.SrpingTp.dto.JeuDto;
import hb.fr.SrpingTp.models.Jeu;

import java.util.List;

public interface JeuService {

    List<JeuDto> getAllJeux();

    JeuDto getJeuById(Long id);

    Jeu saveJeu(JeuDto jeuDto);

    void deleteJeu(Long id);
}
