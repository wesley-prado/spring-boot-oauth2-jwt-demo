package com.devsuperior.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.entities.Role;
import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
  private UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var assignedRoles = repository.searchUserAndRolesByEmail(username);

    if (assignedRoles.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }

    var user = new User();
    user.setEmail(username);
    user.setPassword(assignedRoles.get(0).getPassword());

    assignedRoles.forEach(ur -> user
        .addRole(new Role(ur.getRoleId(), ur.getAuthority())));

    return user;
  }

}
