package thenews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import thenews.components.SectionsComponent;
import thenews.database.CategoryDB;
import thenews.database.UserDB;

@Service
public class IndexService {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private CategoryDB categoryDB;

    @Autowired
    private UserDB userDB;

    public Model modelIndex(Model model){
        model.addAttribute("lastNews", this.sectionsComponent.getLastNews());
        model.addAttribute("mainTopic", this.sectionsComponent.getMainTopic());
        model.addAttribute("subTopic", this.sectionsComponent.getSubTopic());
        model.addAttribute("mostPopular", this.sectionsComponent.getMostPopular());
        model.addAttribute("reports", this.sectionsComponent.getReports());
        model.addAttribute("opinion", this.sectionsComponent.getOpinion());
        model.addAttribute("categories", this.categoryDB.findAll());
        model.addAttribute("users", this.userDB.findAll());
        return model;
    }
}
