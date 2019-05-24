package com.uhcl.amazonsellers.serviceImpl;

import com.uhcl.amazonsellers.domain.AlgorithmData;
import com.uhcl.amazonsellers.domain.AmazonData;
import com.uhcl.amazonsellers.domain.ScrappingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class BulkImporterService {
    private EntityManagerFactory emf;

    @Autowired
    public BulkImporterService(EntityManagerFactory emf) {
        Assert.notNull(emf, "EntityManagerFactory must not be null");
        this.emf = emf;
    }

    public List<ScrappingData> bulkWithEntityManager(List<ScrappingData> items) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        items.forEach(item -> entityManager.persist(item));
        entityManager.getTransaction().commit();
        entityManager.close();
        return items;
    }

    public List<AmazonData> bulkImportWithEntityManager(List<AmazonData> items) {
        EntityManager entityManager1 = emf.createEntityManager();
        entityManager1.getTransaction().begin();
        items.forEach(item -> entityManager1.persist(item));
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return items;
    }

    public List<AlgorithmData> bulkImportWithEntityManagerForAlgorithm(List<AlgorithmData> items) {
        EntityManager entityManager1 = emf.createEntityManager();
        entityManager1.getTransaction().begin();
        items.forEach(item -> entityManager1.persist(item));
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return items;

    }
}
