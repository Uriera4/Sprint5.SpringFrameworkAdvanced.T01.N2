package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("Documentación del Ejercicio Sprint5.Tarea1.Nivel2")
                .version("1.0")
                .description("Documentación Swagger de la API Flor")
                .termsOfService("http://swagger.io/terms")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
