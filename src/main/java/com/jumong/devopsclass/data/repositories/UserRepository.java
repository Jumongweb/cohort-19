package com.jumong.devopsclass.data.repositories;

import com.jumong.devopsclass.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
