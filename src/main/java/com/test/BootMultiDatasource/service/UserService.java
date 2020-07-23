package com.test.BootMultiDatasource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.BootMultiDatasource.dao.UserDaoImpl;
import com.test.BootMultiDatasource.model.User;

@Service
public class UserService {

 @Autowired
 private UserDaoImpl userDao;
 
 public List<User> getAllUser() {
  return userDao.getAllUser();
 }
}
