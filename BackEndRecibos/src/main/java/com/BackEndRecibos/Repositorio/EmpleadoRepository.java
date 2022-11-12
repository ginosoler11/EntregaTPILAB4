package com.BackEndRecibos.Repositorio;

import com.BackEndRecibos.Modelo.Empleado;
import com.BackEndRecibos.Modelo.EmpleadoDTOSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(name = "empleados_simple", nativeQuery = true)
    List<EmpleadoDTOSimple> findEmpleadoDTOSimple();
}
