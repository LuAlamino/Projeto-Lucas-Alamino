package Lucas.Alamino.Projeto_Lucas_Alamino.controller.Exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<String> handleNotFoundException(NoSuchFieldException NotFoundException) {
        return new ResponseEntity<>("Resource ID Não encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        //Versão acima do Java 17 podemos usar o "VAR" em casos que o estilo aj é implisito , como abaixo que é String
        var message = "Unexpected server error, see the logs. ";
        logger.error("", unexpectedException);
        return new ResponseEntity<>("ERRO NO SERVIDOR, VOU OLHAR AS LOGS", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
