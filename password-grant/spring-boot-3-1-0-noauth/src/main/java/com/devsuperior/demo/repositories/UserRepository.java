package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.projections.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query(nativeQuery = true, value = """
      SELECT tb_user.email username, tb_user.password, tb_role.id as roleId, tb_role.authority
      FROM tb_user
      INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
      INNER JOIN tb_role ON tb_user_role.role_id = tb_role.id
      WHERE email = :email
      """)
  List<UserDetailsProjection> searchUserAndRolesByEmail(String email);
}
