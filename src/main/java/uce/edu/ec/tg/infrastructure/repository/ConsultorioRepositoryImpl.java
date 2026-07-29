package uce.edu.ec.tg.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Consultorio;

@ApplicationScoped
@Transactional
public class ConsultorioRepositoryImpl implements PanacheRepositoryBase<Consultorio, Integer> {

    public Consultorio buscarPorNombre(String nombre) {
        return find("nombreConsultorio", nombre).firstResult();
    }

}
