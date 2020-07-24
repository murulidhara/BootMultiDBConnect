package com.test.BootMultiDatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.BootMultiDatasource.service.UserService;

@Controller
//@RequestMapping("/users")
public class UserController {

 @Autowired
 private UserService userService;
 
// @RequestMapping(value = "/users", method = RequestMethod.GET)
// public ModelAndView getAllUsers() {
//  ModelAndView model = new ModelAndView();
//  
//  List<User> usersList = userService.getAllUser();
//  model.addObject("users", usersList);
//  
//  model.setViewName("users");
//  return model;
// }
 
 @GetMapping("/users")
 public String showAll(Model model) {
     model.addAttribute("users", userService.getAllUser());
     return "users";
 }
}
