package bsac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@ComponentScan(basePackages = "bsac")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class CustomSuccessHandlerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Test
    public void showUsernames() {
        System.out.println(customSuccessHandler.getUserByUsername("RichHen"));
    }

}
