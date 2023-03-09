package it.example.securityexample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import it.example.securityexample.model.Users;

/**
 * *Author: Marco Orfei
 * *The Class UserRepository
 */
public interface UserRepository extends JpaRepository<Users, Integer> {

    @EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "authorities" })
    Optional<Users> findByUsername(String username);

    @EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "authorities" })
    List<Users> findAll();

}
