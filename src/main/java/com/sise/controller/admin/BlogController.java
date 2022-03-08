package com.sise.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.pojo.Blog;
import com.sise.pojo.Type;
import com.sise.pojo.User;
import com.sise.querypojo.BlogQuery;
import com.sise.querypojo.SearchBlog;
import com.sise.querypojo.ShowBlog;
import com.sise.service.BlogService;
import com.sise.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    /*博客列表业务逻辑处理*/
    @RequestMapping("/blogs")
    public String BlogPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        //按照时间更新顺序倒序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,7,orderBy);
        List<BlogQuery> allBlog = blogService.getAllBlogQuery();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(allBlog);
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }
    /*搜索业务逻辑处理*/
    @PostMapping("/blogs/search")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        List<BlogQuery> blogQueries = blogService.searchByTitleOrTypeOrRecommend(searchBlog);
        PageHelper.startPage(pageNum,3);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueries);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }

    /*跳转到新增页面*/
    @GetMapping("/blogs/input")
    public String inputPage(Model model) {
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }
    /*新增页面业务处理*/
    @PostMapping("/blogs")
    public String postBlog(Blog blog, Model model, RedirectAttributes attributes, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTypeId(blog.getType().getId());
        blog.setUserId(blog.getUser().getId());
        int i = blogService.saveBlog(blog);
        if (i == 0){
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/blogs";
    }

    /*跳转到编辑博客界面*/
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        ShowBlog blogById = blogService.getBlogById(id);
        List<Type> allType = typeService.getAllType();
        model.addAttribute("blog",blogById);
        model.addAttribute("types",allType);
        return "admin/blogs-input";
    }
    /*编辑博客的业务需求*/
    @PostMapping("/blogs/{id}")
    public String editPost(ShowBlog showBlog,RedirectAttributes attributes){
        int i = blogService.updateBlog(showBlog);
        if (i == 0){
            attributes.addFlashAttribute("message","博客修改失败");
        }else {
            attributes.addFlashAttribute("message","博客修改成功");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        int i = blogService.deleteBlog(id);
        if (i == 0) {
            attributes.addFlashAttribute("message","博客删除失败");
        }else {
            attributes.addFlashAttribute("message","博客删除成功");
        }
        return "redirect:/admin/blogs";
    }








}
