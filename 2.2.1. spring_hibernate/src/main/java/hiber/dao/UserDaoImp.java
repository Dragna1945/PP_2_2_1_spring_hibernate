package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private EntityManager entityManager;

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }



   @Transactional(readOnly = true)

   @Override
   public User getUserByModelAndSeries(String model, int series) {
      User user = sessionFactory.getCurrentSession()
              .createQuery("select u from User u where " +
                      "u.car.model = :model and u.car.series = :series", User.class)
              .setParameter("model", model).setParameter("series", series)
              .getSingleResult();
      return user;
   }



}
