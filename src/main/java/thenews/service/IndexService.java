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
        model.addAttribute("lastnews", this.sectionsComponent.getLastNews());
        model.addAttribute("sports", this.sectionsComponent.getSports());
        model.addAttribute("reports", this.sectionsComponent.getReports());
        model.addAttribute("opinion", this.sectionsComponent.getOpinion());
        model.addAttribute("international", this.sectionsComponent.getInternational());
        model.addAttribute("national", this.sectionsComponent.getNational());
        model.addAttribute("culture", this.sectionsComponent.getCulture());
        model.addAttribute("categories", this.categoryDB.findAll());
        model.addAttribute("users", this.userDB.findAll());
        return model;
    }
}
