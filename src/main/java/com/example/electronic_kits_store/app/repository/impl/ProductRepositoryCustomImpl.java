package com.example.electronic_kits_store.app.repository.impl;

import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductsBySubtype(Class<? extends Product> subtype) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        query.select(product).where(cb.equal(product.type(), subtype));



        return entityManager.createQuery(query).getResultList();
    }
}
