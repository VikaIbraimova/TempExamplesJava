package ru.test.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.model.Auto;
import ru.test.service.ProviderService;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
    private Log log = LogFactory.getLog(ProviderServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Auto> findAll() {
        return em.createNamedQuery("Auto.findAll", Auto.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Auto findById(Long id) {
        TypedQuery<Auto> query = em.createNamedQuery("Auto.findById", Auto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = false)
    public Auto save(Auto auto) {
        if (auto.getId() == null) {
            log.info("Inserting new auto");
            em.persist(auto);
        } else {
            em.merge(auto);
            log.info("Updating existing auto");
        }
        log.info("Auto saved with id: " + auto.getId());
        return auto;
    }

    @Transactional(readOnly = false)
    public void delete(Auto auto) {
        Auto mergedAuto = em.merge(auto);
        em.remove(mergedAuto);
        log.info("Auto with id: " + auto.getId() + " deleted successfully");
    }
}