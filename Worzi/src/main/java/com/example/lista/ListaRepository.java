package com.example.lista;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ListaRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String nombreUsuario);

   

}