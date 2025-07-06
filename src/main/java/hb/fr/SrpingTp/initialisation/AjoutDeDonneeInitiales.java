package hb.fr.SrpingTp.initialisation;

import hb.fr.SrpingTp.dto.CategorieDto;
import hb.fr.SrpingTp.dto.EditionDto;
import hb.fr.SrpingTp.dto.JeuDto;
import hb.fr.SrpingTp.models.*;
import hb.fr.SrpingTp.repository.JeuRepository;
import hb.fr.SrpingTp.services.impl.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class AjoutDeDonneeInitiales implements CommandLineRunner {

    JeuServiceImpl jeuService;
    JoueurServiceImpl joueurService;
    EditionServiceImpl editionService;
    EditeurServiceImpl editeurService;
    CategorieServiceImpl categorieService;

    JeuRepository jeuRepository;

    @Override
    public void run(String... args) throws Exception{

        Joueur j1 = new Joueur();
        j1.setNom("PEDRO");
        j1.setPrenom("Aurélie");
        j1.setEmail("aurelie@test.fr");
        joueurService.saveJoueur(j1);

        System.out.println(joueurService.getAllJoueurs());

        CategorieDto c1 = new CategorieDto();
        c1.setNom("Famille");
        categorieService.saveCategorie(c1);

        CategorieDto c2 = new CategorieDto();
        c2.setNom("Aventure");
        categorieService.saveCategorie(c2);

        System.out.println(categorieService.getAllCategories());

        JeuDto jeu1 = new JeuDto();
        jeu1.setNom("La bonne paye");
        jeu1.setDescription("Pour apprendre aux enfants à gérer leur argent");
        jeu1.setDuree(30);
        jeu1.setNombreJoueursMin(2);
        jeu1.setNombreJoueursMax(6);
        jeu1.setYear(1975);
       jeu1.setCategorieId(1L);
        jeuService.saveJeu(jeu1);

        System.out.println(jeuService.getAllJeux());

        Editeur editeur1 = new Editeur();
        editeur1.setNom("Editeur");
        editeur1.setAdresse("AdresseEditeur");
        editeurService.saveEditeur(editeur1);

        System.out.println(editeurService.getAllEditeurs());

//        EditionDto e1 = new EditionDto();
//        e1.setAnneeEdition(2004);
//        e1.setLangue("francais");
//        e1.setJeuId(1L);
//        //e1.setEditeur(editeur1);
//        editionService.saveEdition(e1);

//        System.out.println(editionService.getAllEditions());

    }
}
