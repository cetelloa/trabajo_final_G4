package uce.edu.ec.tg.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Medico;

@ApplicationScoped
@Transactional
public class MedicoRepositoryImpl implements PanacheRepositoryBase<Medico, Integer> {

}
