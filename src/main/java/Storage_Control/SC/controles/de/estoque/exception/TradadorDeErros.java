package Storage_Control.SC.controles.de.estoque.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TradadorDeErros {


    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<String> tratarProdutoException(ProdutoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
