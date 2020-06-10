package bsac.dao;

import bsac.config.HibernateConfig;
import bsac.config.WebConfig;
import bsac.model.Literature;
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
public class LiteratureRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LiteratureRepository literatureRepository;

    @Test
    public void showAll() {
        for (Literature literature : literatureRepository.findAll(Literature.class, literatureRepository.getBeanToBeAutowired())
        ) {
            System.out.println(literature);
        }
    }
}
