package com.SpringSecurigiriDemo.SpringSecurigiriDemo.exceptions.errors;

import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error extends User {

  private String message;
  private String status;
  private String error;
  private String path;

}
