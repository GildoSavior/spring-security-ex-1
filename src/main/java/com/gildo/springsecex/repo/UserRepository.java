package com.gildo.springsecex.repo;

import com.gildo.springsecex.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByusername(String username);
}
