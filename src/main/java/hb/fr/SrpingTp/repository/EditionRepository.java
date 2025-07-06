package hb.fr.SrpingTp.repository;

import hb.fr.SrpingTp.models.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition
        , Long> {
}
