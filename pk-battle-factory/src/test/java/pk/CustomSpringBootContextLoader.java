package pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootContextLoader;

/**
 * Created by Germain on 02/07/2017.
 */
public class CustomSpringBootContextLoader extends SpringBootContextLoader {

  @Override
  protected SpringApplication getSpringApplication() {
    return new SpringApplicationBuilder().headless(false).build();
  }
}
