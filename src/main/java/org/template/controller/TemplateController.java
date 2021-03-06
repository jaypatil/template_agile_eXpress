package org.template.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Home
 */
@Controller
public class TemplateController {

    @RequestMapping(value = {"/", "index"})
    public String indexPage() {
        return "admin_home";
    }

    @RequestMapping(value = {"product_full_view"})
    public String productFullViewPage() {
        return "product_full_view";
    }

    @RequestMapping(value = {"add_product"})
    public String addProductPage() {
        return "add_product";
    }

    @RequestMapping(value = {"add_task"})
    public String addTaskPage() {
        return "add_task";
    }

    @RequestMapping(value = {"add_user"})
    public String addUserPage() {
        return "add_user";
    }

    @RequestMapping(value = {"add_module"})
    public String addModulePage() {
        return "add_module";
    }

    @RequestMapping(value = {"add_product_backlog"})
    public String addProductBacklogPage() {
        return "add_product_backlog";
    }

    @RequestMapping(value = {"list_product"})
    public String listProductPage() {
        return "list_product";
    }

    @RequestMapping(value = {"list_task"})
    public String listTaskPage() {
        return "list_task";
    }

    @RequestMapping(value = {"list_user"})
    public String listUserPage() {
        return "list_user";
    }

    @RequestMapping(value = {"selected_product"})
    public String selectedProductPage() {
        return "selected_product";
    }

    @RequestMapping(value = {"add_sub_task"})
    public String addSubTaskPage() {
        return "add_sub_task";
    }
     @RequestMapping(value = {"list_sub_task"})
    public String listSubTaskPage() {
        return "list_sub_task";
    }
}
