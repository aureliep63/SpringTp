package hb.fr.SrpingTp.controllers;

import hb.fr.SrpingTp.dto.JeuDto;
import hb.fr.SrpingTp.mapper.JeuMapper;
import hb.fr.SrpingTp.models.Jeu;
import hb.fr.SrpingTp.services.JeuService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jeux")
@Validated
public class JeuRestController {

    private JeuService jeuService;
    private JeuMapper jeuMapper;

    public JeuRestController(JeuService jeuService, JeuMapper jeuMapper) {
        this.jeuMapper = jeuMapper;
        this.jeuService = jeuService;
    }

    @GetMapping("")
    public List<JeuDto> getAllJeux() {
        return jeuService.getAllJeux();  // La méthode dans le service renverra la liste des DTOs
    }

    @GetMapping("/{id}")
    public JeuDto getJeuById(@PathVariable Long id) {
        return jeuService.getJeuById(id); // Retourner le DTO directement
    }

//    @PostMapping("")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public Jeu saveJeu(@Valid @RequestBody JeuDto jeuDto) {
//        return jeuService.saveJeu(jeuDto); // Accepter un DTO en entrée et renvoyer le DTO sauvegardé
//    }
@PostMapping("")
@ResponseStatus(HttpStatus.CREATED)
public JeuDto saveJeu(@RequestBody JeuDto jeuDto) {
    Jeu jeu = jeuService.saveJeu(jeuDto);
    return jeuMapper.toDto(jeu); // éviter de renvoyer l’entité complète
}



    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteJeu(@PathVariable Long id) {
        jeuService.deleteJeu(id);
    }

    @PutMapping("/{id}")
    public Jeu updateJeu(@PathVariable Long id, @Valid @RequestBody JeuDto jeuDto) {
        jeuDto.setId(id); // S'assurer que l'ID est correctement affecté
        return jeuService.saveJeu(jeuDto);  // Sauvegarder et retourner le DTO mis à jour
    }
}
