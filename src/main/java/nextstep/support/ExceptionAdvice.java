package nextstep.support;

import nextstep.support.excpetion.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler()
    public ResponseEntity handleNotExistEntityException(NotExistEntityException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler()
    public ResponseEntity handleUnauthorizedException(InvalidAuthorizationTokenException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler()
    public ResponseEntity handleForbiddenAccessException(NotQualifiedMemberException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @ExceptionHandler({NotCorrectUserNameOrPasswordException.class, DuplicateEntityException.class})
    public ResponseEntity handleBadRequestException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
