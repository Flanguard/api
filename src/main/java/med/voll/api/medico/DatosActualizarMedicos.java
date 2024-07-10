package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;

public record DatosActualizarMedicos (
        @NotNull Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
){
}
