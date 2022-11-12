package com.BackEndRecibos.Modelo;

import javax.persistence.*;

@Entity(name = "ReciboNQ")
@NamedNativeQuery(
        name  = "recibos_por_area",
        query = "SELECT e.area, SUM((r.sueldo_bruto + r.monto_antiguedad) - r.monto_jubilacion - r.montoFAC - r.monto_obra_social) as sueldoNeto FROM recibo r INNER JOIN empleado e ON r.legajo_empleado = e.legajo WHERE ano=:ano AND mes=:mes GROUP BY e.area ORDER BY sueldoNeto DESC",
        resultSetMapping = "recibos_dto"
)
@SqlResultSetMapping(
        name = "recibos_dto",
        classes = @ConstructorResult(
                targetClass =  ReciboNQ.class,
                columns = {
                        @ColumnResult(name = "sueldoNeto", type = Float.class),
                        @ColumnResult(name = "area", type = String.class)
                }
        )
)

public class ReciboNQ {
    @Id
    private float sueldoNeto;

    private String area;

    public ReciboNQ(float sueldoNeto, String area){
        this.sueldoNeto = sueldoNeto;

        this.area = area;
    }

    public float getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(float sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}


