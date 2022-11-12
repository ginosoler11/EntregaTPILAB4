package com.BackEndRecibos.Repositorio;


import com.BackEndRecibos.Modelo.ReciboNQ;
import com.BackEndRecibos.Modelo.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReciboRepository extends JpaRepository<Recibo, Integer> {

    @Query("SELECT r FROM Recibo r WHERE r.legajoEmpleado.legajo = ?1")
    List<Recibo> findRecibos(int legajo);


    @Query(name = "recibos_por_area", nativeQuery = true)
    List<ReciboNQ> findRecibs(@Param(value = "ano") int año, @Param(value = "mes") int mes);


}
