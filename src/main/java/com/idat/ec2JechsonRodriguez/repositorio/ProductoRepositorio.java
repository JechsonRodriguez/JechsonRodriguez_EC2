package com.idat.ec2JechsonRodriguez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec2JechsonRodriguez.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
