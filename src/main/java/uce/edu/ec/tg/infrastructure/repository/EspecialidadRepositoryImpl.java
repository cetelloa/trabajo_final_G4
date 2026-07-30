package uce.edu.ec.tg.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Especialidad;

@ApplicationScoped
@Transactional
public class EspecialidadRepositoryImpl implements PanacheRepositoryBase<Especialidad, Integer> {

    public Especialidad buscarPorId(Integer id) {
        return find("id", id).firstResult();
    }
}
