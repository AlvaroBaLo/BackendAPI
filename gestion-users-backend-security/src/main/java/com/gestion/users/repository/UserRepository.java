package com.gestion.users.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.gestion.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
