package hb.fr.SrpingTp.controllers;

import hb.fr.SrpingTp.models.Joueur;
import hb.fr.SrpingTp.services.JoueurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
@Validated
public class JoueurRestController {

    private JoueurService joueurService;

    public JoueurRestController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping("")
    public List<Joueur> getAllJoueurs() {
        return joueurService.getAllJoueurs();
    }

    @GetMapping("/{id}")
    public Joueur getJoueurById(@PathVariable Long id) {
        return joueurService.getJoueurById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Joueur saveJoueur(@Valid @RequestBody Joueur joueur) {
        return joueurService.saveJoueur(joueur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteJoueur(@PathVariable Long id) {
        joueurService.deleteJoueur(id);
    }

    @PutMapping("/{id}")
    public Joueur updateJeu(@PathVariable Long id,@Valid @RequestBody Joueur joueur) {
        joueur.setId(id);
        return joueurService.saveJoueur(joueur);
    }
}
