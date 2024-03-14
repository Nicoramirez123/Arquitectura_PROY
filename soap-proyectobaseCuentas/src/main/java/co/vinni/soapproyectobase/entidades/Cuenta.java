package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Cuenta")
@Table (name = "CUENTAS")

public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUENTAS")
    @SequenceGenerator(name = "SEQ_CUENTAS", sequenceName = "SEQ_CUENTAS", allocationSize = 1)

    @Column(name = "NO_CUENTA", nullable = false)
    private long no_cuenta;

    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "SALDO", nullable = false)
    private double saldo;

}
