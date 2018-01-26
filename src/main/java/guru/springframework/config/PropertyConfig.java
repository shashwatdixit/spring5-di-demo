package guru.springframework.config;

import guru.springframework.examplebeans.Fakedatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;

    public Fakedatasource fakedatasource(){
        Fakedatasource fakedatasource= new Fakedatasource();
        fakedatasource.setUser(user);
        fakedatasource.setPassword(password);
        fakedatasource.setUrl(url);
        return fakedatasource;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
