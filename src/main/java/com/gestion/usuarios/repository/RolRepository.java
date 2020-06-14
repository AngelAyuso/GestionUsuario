package com.gestion.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.gestion.usuarios.models.entity.Rol;

@Component
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
