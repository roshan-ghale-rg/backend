package com.uhcl.amazonsellers.repository;

import com.uhcl.amazonsellers.domain.ScrappingData;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class BulkImporterRepository extends SimpleJpaRepository<ScrappingData, String> {
    private EntityManager entityManager;
    public BulkImporterRepository(EntityManager entityManager) {
        super(ScrappingData.class, entityManager);
        this.entityManager=entityManager;
    }

    @Transactional
    public List<ScrappingData> save(List<ScrappingData> items) {
        items.forEach(item -> entityManager.persist(item));
        return items;
    }
}
