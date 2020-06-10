package bsac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@ComponentScan(basePackages = "bsac")
@ContextConfiguration(classes = {WebConfig.class, HibernateConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource(value = "classpath:hibernate.properties")
public class SecurityConfigurationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void encoderTest() {
        System.out.println("101".hashCode());

        //48626
    }

    @Test
    public void encoder() {
        String encoded = new BCryptPasswordEncoder().encode("101");
        System.out.println(encoded);
    }


}