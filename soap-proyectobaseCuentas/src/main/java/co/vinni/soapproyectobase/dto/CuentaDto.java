package co.vinni.soapproyectobase.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CuentaDto implements Serializable {

    private long no_cuenta;

    @NotBlank(message = "Campo obligatorio")
    private long id;

    @NotBlank(message = "Campo obligatorio")
    private String nombre;

    @NotBlank(message = "Campo obligatorio")
    private String apellido;

    @NotBlank(message = "Campo obligatorio")
    private double saldo;



}
