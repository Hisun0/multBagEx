package org.example.repository;

import org.example.annotation.Profiling;
import org.example.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Profiling
    @EntityGraph(attributePaths = {"mobileNumbers", "emailAddresses"})
    List<User> findByFullNameContaining(String name);
}
