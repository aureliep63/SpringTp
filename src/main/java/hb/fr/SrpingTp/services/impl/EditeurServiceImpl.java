package hb.fr.SrpingTp.services.impl;

import hb.fr.SrpingTp.models.Editeur;
import hb.fr.SrpingTp.models.Joueur;
import hb.fr.SrpingTp.repository.EditeurRepository;
import hb.fr.SrpingTp.services.EditeurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditeurServiceImpl implements EditeurService {
 private EditeurRepository editeurRepository;

 public EditeurServiceImpl(EditeurRepository editeurRepository) {
  this.editeurRepository = editeurRepository;
 }
    @Override
    public List<Editeur> getAllEditeurs() {
        return editeurRepository.findAll();
    }
    @Override
    public Editeur getEditeurById(Long id) {
        return editeurRepository.findById(id).orElse(null);
    }
    @Override
    public Editeur saveEditeur(Editeur editeur) {
        return editeurRepository.save(editeur);
    }
    @Override
    public void deleteEditeur(Long id) {
        editeurRepository.deleteById(id);
    }

}
