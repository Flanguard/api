package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DatosActualizarMedicos;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepositoy medicoRepositoy;

    @PostMapping
    @Transactional
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        medicoRepositoy.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size= 2) Pageable paginacion){
        //return medicoRepositoy.findAll(paginacion).map(DatosListadoMedico::new);
        return medicoRepositoy.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedicos datosActualizarMedicos){
        Medico medico = medicoRepositoy.getReferenceById(datosActualizarMedicos.id());
        medico.actualizarDatos(datosActualizarMedicos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepositoy.getReferenceById(id);
        medico.desactivarMedico();
    }
//    public void eliminarMedico(@PathVariable Long id){
//        Medico medico = medicoRepositoy.getReferenceById(id);
//        medicoRepositoy.delete(medico);
//    }
}
