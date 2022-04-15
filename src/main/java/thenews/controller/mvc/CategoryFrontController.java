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

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryFrontController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private CategoryDB categoryDB;

    @Autowired
    private UserDB userDB;

    @Autowired
    private PostDB postDB;

    @GetMapping(path = {"/{category}"})
    public ModelAndView getCategory(@PathVariable(required = true, name ="category") String category) {
        ModelAndView modelAndView = new ModelAndView("category");
        List<User> users = userDB.findAll();
        modelAndView.addObject("users", users);
        modelAndView.addObject("categories", this.categoryDB.findAll());
        modelAndView.addObject("mainTopic", this.sectionsComponent.getMainTopic());
        modelAndView.addObject("subTopic", this.sectionsComponent.getSubTopic());
        modelAndView.addObject("mostPopular", this.sectionsComponent.getMostPopular());
        modelAndView.addObject("reports", this.sectionsComponent.getReports());
        modelAndView.addObject("opinion", this.sectionsComponent.getOpinion());
        modelAndView.addObject("postsByCategory", this.postDB.getPostsByCategory(category));
        return modelAndView;
    }
}
