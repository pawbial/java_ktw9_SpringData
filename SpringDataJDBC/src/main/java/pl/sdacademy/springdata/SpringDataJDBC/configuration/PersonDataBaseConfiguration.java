package pl.sdacademy.springdata.SpringDataJDBC.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import pl.sdacademy.springdata.SpringDataJDBC.repository.PersonRepositoryConfiguration;


@Configuration
@EnableJdbcRepositories (basePackageClasses = {PersonRepositoryConfiguration.class})
public class PersonDataBaseConfiguration extends JdbcConfiguration {

    @Autowired
    EmbeddedDatabase dataSource;

    @Bean
    NamedParameterJdbcOperations operations () {
       return new NamedParameterJdbcTemplate(dataSource);
    }
    @Bean
    PlatformTransactionManager transactionManager () {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    EmbeddedDatabase dataSource () {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("scripts/create-person.sql")
                .build();
    }

}
