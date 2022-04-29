package thenews.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thenews.components.SectionsComponent;
import thenews.model.Category;
import thenews.model.Comment;
import thenews.model.Post;
import thenews.model.User;
import thenews.service.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostFrontController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private IndexService indexService;

    @GetMapping("/newPost")
    public ModelAndView newPost(){
        List<Category> categories = categoryService.getAllCategories();
        List<User> users = userService.getAllUsers();
        return new ModelAndView("newPost").addObject("post", new Post())
                .addObject("categories", categories)
                .addObject("users", users);
    }

    @PostMapping("/addNewPost")
    public String addNewPost(Post post, Model model) {
        postService.saveNewPost(post);
        indexService.modelIndex(model);
        return "redirect:/";
    }

    @PostMapping("/newComment")
    public String newComment(Comment comment, Model model) {
        commentService.save(comment);
        indexService.modelIndex(model);
        int postid = comment.getPostid();
        return "redirect:/post/" + postid;
    }

    @GetMapping(path = {"/{post}"})
    public ModelAndView getArticulo(@PathVariable(required = true, name ="post") int id) {
        ModelAndView modelAndView = new ModelAndView("post");
        Post post = this.postService.getPostById(id);
        List<Comment> commentsList = commentService.findByPostId(id);
        List<User> usuarios = userService.getAllUsers();
        modelAndView.addObject("post", post);
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("commentslist", commentsList);
        modelAndView.addObject("users", usuarios);
        modelAndView.addObject("categories", this.categoryService.getAllCategories());
        return modelAndView;
    }
}
