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
        return "index";
    }

    @RequestMapping(value = {"/signinpage"})
    public String helloPage() {
        return "signinpage";
    }

    @RequestMapping(value = {"/sidenavpage"})
    public String sideNavPage() {
        return "sidenavpage";
    }

    @RequestMapping(value = {"/regestrationpage"})
    public String regestrationPage() {
        return "regestration";
    }

    @RequestMapping(value = {"/regestrationpage2"})
    public String regestrationPage2() {
        return "regestration2";
    }

    @RequestMapping(value = {"/userlistpage"})
    public String userlistPage() {
        return "userlist";
    }

}
