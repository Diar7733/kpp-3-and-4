package com.example.springboot.data;

import com.example.springboot.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculationDaoImpl implements CalculationDao {

    @Override
    public List<CalculationEntity> getCalculations() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createCriteria(CalculationEntity.class)
                .list();
    }

    @Override
    public void addCalculation(CalculationEntity entity) {
        SessionFactory factory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
    }
}
