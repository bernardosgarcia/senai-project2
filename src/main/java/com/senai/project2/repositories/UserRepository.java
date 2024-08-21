package com.senai.project2.repositories;

import com.senai.project2.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

   UserModel findByUsername(String username);

}
