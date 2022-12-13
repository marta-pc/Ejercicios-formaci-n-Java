package Persona.repository;

import Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findById(int id);

    Optional<Persona> findByUsuario(String usuario);
}
