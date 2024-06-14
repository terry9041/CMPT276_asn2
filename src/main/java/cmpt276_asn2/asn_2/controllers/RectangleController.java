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

    // Read
    // When the user goes to the home page
    // it will add / to the URL
    // This will call the getAllRectangles method and get all the rectangles
    // Then it will add the rectangles to the model and return the index page
    // Finally we can use Thymeleaf to display the rectangles
    @GetMapping("/")
    public String getAllRectangles(Model model) {
        model.addAttribute("rectangles", rectangleService.getAllRectangles());
        return "index";
    }

    // Read
    // When the user clicks the detail button on the index page
    // it will add /rectangle/{id} to the URL
    // This will call the getRectangleById method and get the rectangle with the id
    // th:href="@{/rectangle/{id}(id=${rectangle.id})}"
    // Then it will add the rectangle to the model and return the detail page
    @GetMapping("/rectangle/{id}")
    public String getRectangleById(@PathVariable Long id, Model model) {
        Optional<Rectangle> rectangle = rectangleService.getRectangleById(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "detail";
        } else {
            return "error";
        }
    }

    // Create
    // When the user clicks the create button on the index page
    // it will add /rectangle/new to the URL
    // This will call the createRectangleForm method and create a new rectangle
    // The rectangle will be added to the model and the user will be redirected to
    // the create page
    // Then we can edit the new rectangle attribute in the create page
    @GetMapping("/rectangle/new")
    public String createRectangleForm(Model model) {
        model.addAttribute("rectangle", new Rectangle());
        return "create";
    }

    // Create
    // When the user clicks the submit button on the create page
    // it will add /rectangle to the URL
    // This will call the saveRectangle method and save the rectangle
    // Then it will redirect the user back to the index page
    @PostMapping("/rectangle")
    public String saveRectangle(@ModelAttribute Rectangle rectangle) {
        rectangleService.saveRectangle(rectangle);
        return "redirect:/";
    }

    // Delete
    // When the user clicks the delete button on the index page
    // it will add /rectangle/delete/{id} to the URL
    // This will call the deleteRectangle method and delete the rectangle with the
    // id
    // Then it will redirect the user back to the index page
    @GetMapping("/rectangle/delete/{id}")
    public String deleteRectangle(@PathVariable Long id) {
        rectangleService.deleteRectangle(id);
        return "redirect:/";
    }

    // Update from detail.html
    // When the user clicks the update button on the detail page
    // it will add /rectangle/update/{id} to the URL
    // This will call the updateRectangleFromDetail method and update the rectangle
    // This is done by setting the model attribute's ID to the one we want to update
    // Then it will post to the DB, cuz it's duplicated, it will update the existing
    // Finally it will redirect the user back to the index page
    @PostMapping("/rectangle/update/{id}")
    public String updateRectangleFromDetail(@PathVariable Long id, @ModelAttribute Rectangle rectangle) {
        rectangle.setId(id);
        rectangleService.saveRectangle(rectangle);
        return "redirect:/";
    }
}
