package terletskayasamuseva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import terletskayasamuseva.config.web.WebConfig;

@Configuration
@ComponentScan(basePackages = "terletskayasamuseva")
@PropertySource(value = {
        "classpath:hibernate.properties"
})
@Import(value = {
        HibernateConfig.class,
        WebConfig.class
})
public class AppConfig {
}

