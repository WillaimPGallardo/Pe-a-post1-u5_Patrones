package com.universidad.patrones.service;

import com.universidad.patrones.model.Libro;
import com.universidad.patrones.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibroService {

    private final LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public List<Libro> findAll() {
        return repo.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return repo.findById(id);
    }

    public Libro save(Libro libro) {
        if (repo.existsByIsbn(libro.getIsbn())) {
            throw new RuntimeException("ISBN duplicado");
        }
        return repo.save(libro);
    }

    public Libro update(Long id, Libro datos) {
        Libro libro = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        libro.setTitulo(datos.getTitulo());
        libro.setAutor(datos.getAutor());
        libro.setCategoria(datos.getCategoria());
        libro.setAnioPublicacion(datos.getAnioPublicacion());

        return repo.save(libro);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}