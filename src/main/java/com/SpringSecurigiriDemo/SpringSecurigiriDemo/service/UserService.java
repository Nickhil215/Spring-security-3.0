package com.SpringSecurigiriDemo.SpringSecurigiriDemo.service;

import static com.SpringSecurigiriDemo.SpringSecurigiriDemo.exceptions.errors.ErrorMsgs.USER_ALREADY_EXISTS;

import com.SpringSecurigiriDemo.SpringSecurigiriDemo.exceptions.UserAlreadyExistsException;
import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.User;
import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.UserInfo;
import com.SpringSecurigiriDemo.SpringSecurigiriDemo.repo.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private PasswordEncoder encoder;

  public User save(UserInfo userInfo)  {
    if (userRepo.existsByUsername(userInfo.getUsername())) {
      throw new UserAlreadyExistsException(USER_ALREADY_EXISTS) ;
//      return USER_ALREADY_EXISTS;
    }
    return userRepo.save(userInfo);
  }

  public List<UserInfo> get() {
    return userRepo.findAll();
  }

  public User saveUser(UserInfo user) {
    user.setPassword(encoder.encode(user.getPassword()));
    return userRepo.save(user);
  }
}
