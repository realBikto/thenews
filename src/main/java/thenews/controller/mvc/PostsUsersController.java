package thenews.controller.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thenews.model.User;
import thenews.service.PostService;
import thenews.service.UserService;

@Controller
@RequestMapping("/user")
public class PostsUsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping(path = {"/{user}"})
    public ModelAndView getCategory(@PathVariable(required = true, name ="user") int userid) {
        ModelAndView modelAndView = new ModelAndView("user");
        User user = userService.findById(userid);
        modelAndView.addObject("user", user);
        modelAndView.addObject("postsByUser", this.postService.getPostsByUser(userid));
        return modelAndView;
    }
}
