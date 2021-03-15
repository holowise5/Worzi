package com.example.tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lista.Lista;



public interface TarjetaRepository extends JpaRepository<Lista, Long> {

    Lista findByNombre(String nombreLista);

   

}