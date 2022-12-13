package com.bosonit.block5logging;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@Component
@RestController
@CommonsLog

public class LogError {


    @Bean
    public String index() {

        log.error("Mensaje a nivel de ERROR");
        log.warn("Mensaje a nivel de WARNING");
        log.info("Mensaje a nivel de INFO");

        return "Los logs de error han sido almacenados en el archivo ";
    }
}
