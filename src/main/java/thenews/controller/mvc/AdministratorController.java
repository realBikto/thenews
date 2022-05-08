package thenews.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thenews.components.SectionsComponent;
import thenews.model.*;
import thenews.service.*;

import java.util.List;

@Component
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private SectionsComponent sectionsComponent;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostSectionService postSectionService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private UserService userService;

    @GetMapping(path = {"/posts"})
    public ModelAndView getPostList() {
        ModelAndView modelAndView = new ModelAndView("post-management");
        modelAndView.addObject("posts", this.postService.findAll());
        modelAndView.addObject("categories", this.categoryService.getAllCategories());
        return modelAndView;
    }

    @GetMapping("/modify/{post}")
    public ModelAndView updatePost(@PathVariable(required = true, name ="post") int id){
        List<Category> categories = categoryService.getAllCategories();
        List<User> users = userService.getAllUsers();
        Post post = this.postService.getPostById(id);
        return new ModelAndView("update-post").addObject("post", post)
                .addObject("categories", categories)
                .addObject("users", users);
    }

    @PostMapping("/modifyPost")
    public String updatePost(Post post, Model model) {
        postService.updatePost(post);
        indexService.modelIndex(model);
        return "redirect:/admin/posts";
    }

    @GetMapping("/deletePost")
    public String deletePost(Post post, Model model) {
        postService.deleteById(post.getPostid());
        indexService.modelIndex(model);
        return "redirect:/admin/posts";
    }

    @GetMapping("/modifySection/{post}")
    public ModelAndView updatePostSection(@PathVariable(required = true, name ="post") int id){
        List<Category> categoryList = this.categoryService.getAllCategories();
        List<Section> sectionList = this.sectionService.findAll();
        Post post = this.postService.getPostById(id);
        PostSection postSection = postSectionService.findByPostId(id);
        if (postSection.getPostid() != null){
            return new ModelAndView("update-post-section")
                    .addObject("postSection", postSection)
                    .addObject("post", post)
                    .addObject("sections", sectionList)
                    .addObject("categories", categoryList);
        } else {
            postSection.setPostid(id);
            postSection.setSectionid(1);
            return new ModelAndView("update-post-section")
                    .addObject("postSection", postSection)
                    .addObject("post", post)
                    .addObject("sections", sectionList)
                    .addObject("categories", categoryList);
        }
    }

    @PostMapping("/modifySection")
    public String updatePostSection(Post post, Section section) {
        postSectionService.updatePostSection(post, section);
        return "redirect:/admin/posts";
    }
}
