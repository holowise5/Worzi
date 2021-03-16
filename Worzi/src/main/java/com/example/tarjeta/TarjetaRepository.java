package com.example.tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    Tarjeta findByNombre(String nomTarjeta);

}