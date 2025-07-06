package hb.fr.SrpingTp.controllers;

import hb.fr.SrpingTp.models.Editeur;
import hb.fr.SrpingTp.services.EditeurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editeurs")
@Validated
public class EditeurRestController {


    private EditeurService editeurService;

    public EditeurRestController(EditeurService editeurService){
        this.editeurService = editeurService;
    }

    @GetMapping("")
    public List<Editeur> getAllEditeurs() {
        return editeurService.getAllEditeurs();
    }

    @GetMapping("/{id}")
    public Editeur getEditeurById(@PathVariable Long id) {
        return editeurService.getEditeurById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Editeur saveEditeur(@Valid @RequestBody Editeur editeur) {
        return editeurService.saveEditeur(editeur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEditeur(@PathVariable Long id) {
        editeurService.deleteEditeur(id);
    }

    @PutMapping("/{id}")
    public Editeur updateEditeur(@PathVariable Long id,@Valid @RequestBody Editeur editeur) {
        editeur.setId(id);
        return editeurService.saveEditeur(editeur);
    }
}
