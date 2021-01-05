package com.geekbrains.shop.controller;

import com.geekbrains.shop.entities.User;
import com.geekbrains.shop.dto.UserDto;
import com.geekbrains.shop.service.UserService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/new")
    public String saveUser(UserDto dto, Model model) {
        if (userService.save(dto)) {
            return "redirect:/users";
        } else {
            model.addAttribute("user", dto);
            return "user";
        }
    }

    @PostAuthorize("isAuthenticated() and #username == authentication.principal.username")
    @GetMapping("/{name}/roles")
    @ResponseBody
    public String getRoles(@PathVariable("name") String username) {
        System.out.println("Called method getRoles");
        User byName = userService.findByName(username);
        return byName.getRole().name();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal) {
        if (principal == null) {
            throw new RuntimeException("You are not authorized");
        }
        UserDto userDto = userService.findDtoByName(principal.getName());
        model.addAttribute("user", userDto);
        return "profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profile")
    public String updateProfileUser(UserDto dto, Model model, Principal principal) {
        if (principal == null
                || !Objects.equals(principal.getName(), dto.getName())) {
            throw new RuntimeException("You are not authorized");
        }
        if (dto.getPassword() != null
                && !dto.getPassword().isEmpty()
                && !Objects.equals(dto.getPassword(), dto.getMatchingPassword())) {
            model.addAttribute("user", dto);
            return "/users/profile";
        }
        userService.updateProfile(dto);
        return "redirect:/users/profile";
    }

}
