package Repositorires;

import entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoriRepository extends JpaRepository<Autore, Integer> {
    Optional<Autore> findByEmail(String email);
}
