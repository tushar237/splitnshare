package com.lekha.jokha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekha.jokha.entities.User;

@Repository("usersRepo")
public interface UsersRepo extends JpaRepository<User, String> {

}
