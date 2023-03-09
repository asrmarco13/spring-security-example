package it.example.securityexample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.example.securityexample.model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

    Optional<Authorities> findByAuthority();
}
