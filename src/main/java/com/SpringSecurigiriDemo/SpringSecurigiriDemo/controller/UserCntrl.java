package com.SpringSecurigiriDemo.SpringSecurigiriDemo.controller;

import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.User;
import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.UserInfo;
import com.SpringSecurigiriDemo.SpringSecurigiriDemo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCntrl {


  @Autowired
  private UserService userService;


  @PostMapping("/save")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  public User save(@RequestBody UserInfo userInfo) {
    return userService.save(userInfo);
  }


  @PostMapping ("/saveUser")
  public User saveUser(@RequestBody UserInfo user) {

    return userService.saveUser(user);
  }




  @GetMapping("/get")
  @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
  public List<UserInfo> get() {
    return userService.get();
  }

  @GetMapping("/get/{id}")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public List<UserInfo> getById(@PathVariable String id) {
    return userService.get();
  }

    @GetMapping("/welcome")
  public String welcome() {
    return "Welcome to Spring Security";
  }

}
