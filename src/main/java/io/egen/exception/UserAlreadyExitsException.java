package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User already exists")
public class UserAlreadyExitsException extends Exception{
	private static final long serialVersionUID = 74997228926755962L;

}
