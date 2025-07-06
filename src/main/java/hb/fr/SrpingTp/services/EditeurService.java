package hb.fr.SrpingTp.services;

import hb.fr.SrpingTp.models.Editeur;

import java.util.List;

public interface EditeurService {

    List<Editeur> getAllEditeurs();

    Editeur getEditeurById(Long id);

    Editeur saveEditeur(Editeur editeur);

    void deleteEditeur(Long id);}
