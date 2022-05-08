package thenews.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thenews.components.SectionsComponent;
import thenews.database.CategoryDB;
import thenews.database.PostDB;
import thenews.database.UserDB;
import thenews.model.User;
import thenews.service.CategoryService;
import thenews.service.PostService;
import thenews.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryFrontController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping(path = {"/{category}"})
    public ModelAndView getCategory(@PathVariable(required = true, name ="category") String category) {
        ModelAndView modelAndView = new ModelAndView("category");
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("categories", this.categoryService.getAllCategories());
        modelAndView.addObject("sports", this.sectionsComponent.getSports());
        modelAndView.addObject("reports", this.sectionsComponent.getReports());
        modelAndView.addObject("opinion", this.sectionsComponent.getOpinion());
        modelAndView.addObject("international", this.sectionsComponent.getInternational());
        modelAndView.addObject("national", this.sectionsComponent.getNational());
        modelAndView.addObject("culture", this.sectionsComponent.getCulture());
        modelAndView.addObject("postsByCategory", this.postService.getPostsByCategory(category));
        return modelAndView;
    }
}
