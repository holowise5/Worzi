package com.example.lista;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ListaRepository extends JpaRepository<Lista, Long> {

    Lista findByNombre(String nombreLista);

   

}