package com.sise.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sise.pojo.Type;
import com.sise.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /*
     * 跳转到分类页面，并进程对分页操作
     * */
    @GetMapping("/types")
    public String TypePage(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段倒叙排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 3, orderBy);
        List<Type> type = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<Type>(type);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    /*
     * 跳转到新增页面
     * */
    @GetMapping("/types/input")
    public String InputTypePage(Model model) {
        /*和编辑共用一个页面，不弄的话就会有bug*/
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    /*
     * 处理新增业务逻辑
     * */
    @PostMapping("/types")
    public String inputPost(Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        int t = typeService.saveType(type);
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    /*跳转到编辑页面*/
    @GetMapping("/types/{id}/input")
    public String editType(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    /*处理编辑业务逻辑*/
    @PostMapping("/types/{id}")
    public String updatePost(Type type, Model model, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        int i = typeService.updateType(type);
        if (i == 0) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    /*删除业务逻辑*/
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        int i = typeService.deleteType(id);
        if (i == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        } else {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/types";
    }


}
