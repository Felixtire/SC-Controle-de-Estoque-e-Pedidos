package Storage_Control.SC.controles.de.estoque;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ScControlesDeEstoqueApplication {

	public static void main(String[] args) {

		SpringApplication.run(ScControlesDeEstoqueApplication.class, args);
        log.info("##########Aplicação de Controle de Estoque iniciada com sucesso!##########");
	}

}
