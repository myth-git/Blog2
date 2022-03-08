package com.sise.controller;

import com.github.pagehelper.PageInfo;
import com.sise.querypojo.BlogQuery;
import com.sise.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 归档展示
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String show(Model model) {
        /*调用查询所有博客，之前后端写过*/
        List<BlogQuery> allBlogQuery = blogService.getAllBlogQuery();
        /*一共有多少篇文章*/
        PageInfo<BlogQuery> info = new PageInfo<>(allBlogQuery);
        model.addAttribute("infos",info);
        model.addAttribute("blogs",allBlogQuery);
        return "archives";
    }

}
