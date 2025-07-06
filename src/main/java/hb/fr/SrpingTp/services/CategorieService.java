package hb.fr.SrpingTp.services;

import hb.fr.SrpingTp.dto.CategorieDto;
import hb.fr.SrpingTp.models.Categorie;

import java.util.List;

public interface CategorieService {

    List<CategorieDto> getAllCategories();

    CategorieDto getCategorieById(Long id);

    Categorie saveCategorie(CategorieDto categorieDto);

    void deleteCategorie(Long id);
}
