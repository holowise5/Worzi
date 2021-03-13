package com.example.lista;

import org.springframework.data.jpa.repository.JpaRepository;



public interface TarjetaRepository extends JpaRepository<Lista, Long> {

    Lista findByNombreUsuario(String nombreLista);

   

}