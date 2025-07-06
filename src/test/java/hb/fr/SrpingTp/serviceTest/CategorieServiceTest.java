package hb.fr.SrpingTp.serviceTest;

import hb.fr.SrpingTp.models.Categorie;
import hb.fr.SrpingTp.repository.CategorieRepository;
import hb.fr.SrpingTp.services.impl.CategorieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//public class CategorieServiceTest {
//
//    @Mock
//    CategorieRepository categorieRepositoryMock;
//
//    @InjectMocks
//    CategorieServiceImpl categorieService;
//
//    @Test
//    void saveCategorieTest(){
//        Categorie categ = new Categorie(null, "testCateg");
//        when(categorieRepositoryMock.save(categ)).thenReturn(categ);
//        Long categId = categ.getId();
//        Categorie categSaved = categorieService.saveCategorie(categ);
//        assertEquals(categSaved.getId(), categId);
//    }
//}
