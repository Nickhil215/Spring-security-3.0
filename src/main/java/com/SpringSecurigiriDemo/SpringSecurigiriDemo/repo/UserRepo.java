package com.SpringSecurigiriDemo.SpringSecurigiriDemo.repo;

import com.SpringSecurigiriDemo.SpringSecurigiriDemo.model.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, String> {

  boolean existsByUsername(String username);

  Optional<UserInfo> findByUsername(String username);
}
