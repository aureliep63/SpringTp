package hb.fr.SrpingTp.repository;

import hb.fr.SrpingTp.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository
        extends JpaRepository<Categorie, Long> {
}
