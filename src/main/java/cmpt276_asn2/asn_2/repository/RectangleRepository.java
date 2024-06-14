package cmpt276_asn2.asn_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// Added for the type used in the interface
import cmpt276_asn2.asn_2.entity.Rectangle;

public interface RectangleRepository extends JpaRepository<Rectangle, Long> {

}
