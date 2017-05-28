package generator;

import generator.controller.TresorController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Germain on 28/05/2017.
 */
@Configuration
@Import(value = {TresorController.class})
public class ConfigTest {

}
