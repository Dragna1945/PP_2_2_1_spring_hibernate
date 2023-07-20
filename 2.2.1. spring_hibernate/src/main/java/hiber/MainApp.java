package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

     UserService userService = context.getBean(UserService.class);
     System.out.println((userService.getUserByCarModelAndSeries("Car2 model",234)).toString());
   /*   User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Car1 Model", 123);
      user1.setCar(car1);
      userService.add(user1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Car2 Model", 234);
      user2.setCar(car2);
      userService.add(user2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("Car3 Model", 345);
      user3.setCar(car3);
      userService.add(user3);



//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

    */

      context.close();
   }
}
