package com.vicitf.token.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicitf.token.annotation.Token;
import com.vicitf.token.model.User;

@Controller
public class IndexController {
    
    private int id = 0;
    private List<User> list = new ArrayList<User>();
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            result.append(i + 1).append(". ").append(list.get(i).toString()).append("<br/>");
        }
        return result.toString();
    }
    
    @RequestMapping("/")
    @Token(save = true)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @Token(remove = true)
    public String signup(String user, String pass, RedirectAttributes attr) {
        this.id = this.id + 1;
        boolean flag = false;
        for (User u2 : list) {
            if (u2.getUser().equals(user)) {
                flag = true;
            }
        }
        if (!flag) {
            User u = new User(id, user, pass);
            list.add(u);
            attr.addFlashAttribute("u", u.toString());
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String toSingin() {
        return "signin";
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String singin(String user, String pass, HttpSession session, RedirectAttributes attr) {
        User loginUser = null;
        for (User u : list) {
            if (u.getUser().equals(user) && u.getPass().equals(pass)) {
                loginUser = u;
            }
        }
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            return "redirect:/main";
        } else {
            attr.addFlashAttribute("msg", "invalidate!");
            return "redirect:/signin";
        }
    }
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpSession session, RedirectAttributes attr) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            attr.addFlashAttribute("msg", "please sing in");
            return "redirect:/signin";
        } else {
            return "main";
        }
    }
    
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public String singout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/signin";
    }
}