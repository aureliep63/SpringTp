package hb.fr.SrpingTp.repository;

import hb.fr.SrpingTp.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur
        , Long> {
}
