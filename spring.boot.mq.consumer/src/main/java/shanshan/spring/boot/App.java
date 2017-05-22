package shanshan.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import shanshan.spring.boot.jpa.repository.expand.ExpandRepositoryFactoryBean;

/**
 * Hello world!
 *
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(repositoryFactoryBeanClass = ExpandRepositoryFactoryBean.class)
public class App 
{
	public static void main( String[] args ){
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(App.class, args);
    }
}
