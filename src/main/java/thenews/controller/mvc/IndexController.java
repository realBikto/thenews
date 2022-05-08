package thenews.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thenews.model.User;
import thenews.service.IndexService;
import thenews.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private IndexService indexService;

    @GetMapping
    public String home(Model model){
        indexService.modelIndex(model);
        return "index";
    }

    @GetMapping(path = "/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView newUser(){
        return new ModelAndView("register").addObject("user", new User());
    }

    @PostMapping("/register")
    public String addNewUser(User user) {
        userService.saveNewUser(user);
        return "redirect:/";
    }
}
