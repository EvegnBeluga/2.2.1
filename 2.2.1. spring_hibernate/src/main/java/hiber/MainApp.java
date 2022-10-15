package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("Seva", "Sevkin", "user1@mail.ru", new Car("Volga", 3102)));
      userService.add(new User("Vasya", "Vasilkov", "user2@mail.ru", new Car("Niva", 2121)));
      userService.add(new User("Petya", "Petrov", "user3@mail.ru", new Car("Lada", 2109)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Model = " + user.getCar().getModel());
         System.out.println("Series = " + user.getCar().getSeries());
      }

      User userByCar = userService.getUserByCarModelAndSeries("Volga", 3102);
      System.out.println("\nUser found = " + userByCar.getFirstName());

      context.close();
   }
}