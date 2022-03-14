package com.nix.weather.persistence.repository;

import com.nix.weather.persistence.entity.RequestInfo;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@NoArgsConstructor
public class RequestInfoRepositoryImpl implements RequestInfoRepository {

    @Setter
    @PersistenceContext(unitName = "requestPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void add(RequestInfo requestInfo) {
        entityManager.persist(requestInfo);
    }
}
