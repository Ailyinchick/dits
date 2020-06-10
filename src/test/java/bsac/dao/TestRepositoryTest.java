package bsac.dao;

import bsac.config.HibernateConfig;
import bsac.config.WebConfig;
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
public class TestRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void showAll() {
        for (bsac.model.Test test : testRepository.findAll(bsac.model.Test.class, testRepository.getBeanToBeAutowired())
        ) {
            System.out.println(test);
        }
    }

    @Test
    public void testsDifficulty() {
        for (bsac.model.Test t : testRepository.findAll(bsac.model.Test.class, testRepository.getBeanToBeAutowired())
        ) {
            System.out.println(t.getName() +" - "+testRepository.testsDifficulty(t.getTestId()));
        }
    }

}
