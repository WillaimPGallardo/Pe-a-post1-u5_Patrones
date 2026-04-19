package com.universidad.patrones.repository;

import com.universidad.patrones.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByIsbn(String isbn);
}