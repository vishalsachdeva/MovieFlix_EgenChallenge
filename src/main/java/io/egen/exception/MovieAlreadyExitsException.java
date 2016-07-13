package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Movie already exists")
public class MovieAlreadyExitsException extends Exception{

	private static final long serialVersionUID = -8670685309696261765L;

}
