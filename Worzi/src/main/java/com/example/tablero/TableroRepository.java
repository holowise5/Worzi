package com.example.tablero;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TableroRepository extends JpaRepository<Tablero, Long> {

    Tablero findByNombre(String nombre);

}