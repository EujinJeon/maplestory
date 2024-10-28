package com.example.maplestory.domain.dao;

import com.example.maplestory.domain.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCharacterName(String characterName);

}
