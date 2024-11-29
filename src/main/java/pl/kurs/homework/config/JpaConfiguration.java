package pl.kurs.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JpaConfiguration {

    @Bean
    public LocalEntityManagerFactoryBean createEMF() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("springPersistencePostgres");
        return emf;
    }
}
