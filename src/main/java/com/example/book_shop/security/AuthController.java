package com.example.book_shop.security;

import com.example.book_shop.security.dto.RegisterDto;
import com.example.book_shop.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


//    @PostMapping("/register")
//    public String register(@RequestParam("username") String name,
//                           @RequestParam("phoneNumber") String phoneNumber,
//                           @RequestParam("email") String email,
//                           @RequestParam("password") String password) throws IOException{
//        userService.register( new RegisterDto(name, phoneNumber, email, password));
////        return "redirect:/";
//
//       return "auth/sign-in";
//    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }
    @GetMapping("/register")
    public String getRegister(){
        return "auth/register";
    }

    @GetMapping("/sign-in")
    public String getSignIn(){
        return "auth/sign-in";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDto registerDto){
        userService.register(registerDto);
        return "auth/register";
    }



}