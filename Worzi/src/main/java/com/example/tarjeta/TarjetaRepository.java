package com.example.tarjeta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    List<Tarjeta> findByNombre(String nomTarjeta);

}