package hb.fr.SrpingTp.services.impl;

import hb.fr.SrpingTp.dto.JoueurDto;
import hb.fr.SrpingTp.models.Joueur;
import hb.fr.SrpingTp.repository.JoueurRepository;
import hb.fr.SrpingTp.services.JoueurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class JoueurServiceImpl implements JoueurService {


    private JoueurRepository joueurRepository;

    public JoueurServiceImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }
    @Override
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }
    @Override
    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).orElse(null);
    }
    @Override
    public Joueur saveJoueur(Joueur joueur) {
        joueur.setDateInscription(LocalDate.now());
        return joueurRepository.save(joueur);
    }
    @Override
    public void deleteJoueur(Long id) {
        joueurRepository.deleteById(id);
    }



}
