package med.voll.api.medico;

public record DatosListadoMedico(
        Long id,
        String nombre,
        Especialidad especialidad,
        String documento,
        String email
) {
    public DatosListadoMedico(Medico medico){
        this(medico.getId(), medico.getNombre(), Especialidad.valueOf(medico.getEspecialidad().toString()), medico.getDocumento(), medico.getEmail());
    }
}
