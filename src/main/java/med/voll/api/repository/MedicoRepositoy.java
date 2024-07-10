package med.voll.api.repository;

import med.voll.api.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositoy extends JpaRepository<Medico, Long > {
    Page<Medico> findByActivoTrue(Pageable paginacion);
}
