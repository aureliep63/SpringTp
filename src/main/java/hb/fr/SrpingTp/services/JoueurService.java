package hb.fr.SrpingTp.services;

import hb.fr.SrpingTp.models.Joueur;

import java.util.List;

public interface JoueurService {

    List<Joueur> getAllJoueurs();

    Joueur getJoueurById(Long id);

    Joueur saveJoueur(Joueur joueur);

    void deleteJoueur(Long id);
}
