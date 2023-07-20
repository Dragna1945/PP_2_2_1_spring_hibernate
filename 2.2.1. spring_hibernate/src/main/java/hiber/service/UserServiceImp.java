package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;
   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Query query = (Query) entityManager.createQuery(
              "SELECT u FROM User u WHERE u.car.model = :model AND u.car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return (User) query.getSingleResult();
   }
}