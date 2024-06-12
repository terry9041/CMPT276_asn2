package cmpt276_asn2.asn_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// Add this import statement if the Rectangle class exists in the specified package
import cmpt276_asn2.asn_2.entity.Rectangle;

public interface RectangleRepository extends JpaRepository<Rectangle, Long> {

}
