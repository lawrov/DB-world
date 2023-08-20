package com.javarush.dao;

import com.javarush.domain.CityEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityDAO {

    private final SessionFactory sessionFactory;

    public CityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CityEntity> getItems(int offset, int limit) {
        Query<CityEntity> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM CityEntity c", CityEntity.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount() {
        Query<Long> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(c) FROM CityEntity c", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    public CityEntity getById(Integer id) {
        Query<CityEntity> query = sessionFactory.getCurrentSession()
                .createQuery("select c from CityEntity c join fetch c.country where c.id = :ID", CityEntity.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

}
