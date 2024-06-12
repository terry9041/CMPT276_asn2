package cmpt276_asn2.asn_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import cmpt276_asn2.asn_2.entity.Rectangle;
import cmpt276_asn2.asn_2.service.RectangleService;

@Controller
public class RectangleController {
    @Autowired
    private RectangleService rectangleService;

    @GetMapping("/")
    public String getAllRectangles(Model model) {
        model.addAttribute("rectangles", rectangleService.getAllRectangles());
        return "index";
    }

    @GetMapping("/rectangle/{id}")
    public String getRectangleById(@PathVariable Long id, Model model) {
        Optional<Rectangle> rectangle = rectangleService.getRectangleById(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "detail"; // Ensure this matches the template name
        } else {
            return "error";
        }
    }

    @GetMapping("/rectangle/new")
    public String createRectangleForm(Model model) {
        model.addAttribute("rectangle", new Rectangle());
        return "create";
    }

    @PostMapping("/rectangle")
    public String saveRectangle(@ModelAttribute Rectangle rectangle) {
        rectangleService.saveRectangle(rectangle);
        return "redirect:/";
    }

    @GetMapping("/rectangle/edit/{id}")
    public String editRectangleForm(@PathVariable Long id, Model model) {
        Optional<Rectangle> rectangle = rectangleService.getRectangleById(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "edit";
        } else {
            return "error";
        }
    }

    @PostMapping("/rectangle/{id}")
    public String updateRectangle(@PathVariable Long id, @ModelAttribute Rectangle rectangle) {
        rectangle.setId(id);
        rectangleService.saveRectangle(rectangle);
        return "redirect:/";
    }

    @GetMapping("/rectangle/delete/{id}")
    public String deleteRectangle(@PathVariable Long id) {
        rectangleService.deleteRectangle(id);
        return "redirect:/";
    }
}
