package hb.fr.SrpingTp.controllers;

import hb.fr.SrpingTp.dto.CategorieDto;
import hb.fr.SrpingTp.models.Categorie;
import hb.fr.SrpingTp.services.CategorieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/categories")
public class CategorieRestController {

    private CategorieService categorieService;

    public CategorieRestController(CategorieService categorieService){
        this.categorieService = categorieService;
    }

    @GetMapping("")
    public List<CategorieDto> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategorieDto getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categorie saveCategorie(@Valid @RequestBody CategorieDto categorieDto) {
        return categorieService.saveCategorie(categorieDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }

    @PutMapping("/{id}")
    public Categorie updateCategorie(@PathVariable Long id,@Valid @RequestBody CategorieDto categorieDto) {
        categorieDto.setId(id);
        return categorieService.saveCategorie(categorieDto);
    }
}
