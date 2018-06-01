package pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Germain on 01/07/2017.
 */
@SpringBootApplication
public class PkApplication {

  static { // To be able to use Clipboard
    System.setProperty("java.awt.headless", "false");
  }

  public static void main(String[] args) {
    SpringApplication.run(PkApplication.class, args);
  }

}
