package cmpt276_asn2.asn_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import cmpt276_asn2.asn_2.repository.RectangleRepository;
import cmpt276_asn2.asn_2.entity.Rectangle;

@Service
public class RectangleService {
    @Autowired
    private RectangleRepository rectangleRepository;

    public List<Rectangle> getAllRectangles() {
        return rectangleRepository.findAll();
    }

    public Optional<Rectangle> getRectangleById(Long id) {
        return rectangleRepository.findById(id);
    }

    public Rectangle saveRectangle(Rectangle rectangle) {
        return rectangleRepository.save(rectangle);
    }

    public void deleteRectangle(Long id) {
        rectangleRepository.deleteById(id);
    }
}
