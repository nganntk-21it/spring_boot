package com.example.demo.controller;

import com.example.demo.entities.AccountEntity;
import com.example.demo.services.AccountServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private AccountServices accountService;

    @GetMapping("/")
    public String defaultLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String account,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        AccountEntity user = accountService.login(account, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    @GetMapping("/employees")
    public String showEmployeeList(HttpSession session, Model model) {
        AccountEntity account = (AccountEntity) session.getAttribute("loggedInUser");
        if (account != null) {
            return "employee-list"; // dummy view
        }
        model.addAttribute("loggedInUser", account);
        return "employee-list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
