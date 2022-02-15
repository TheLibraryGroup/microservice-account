package org.thibaut.thelibrary.account.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thibaut.thelibrary.account.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.account.service.AccountService;
import org.thibaut.thelibrary.account.service.dto.AccountDTO;
import org.thibaut.thelibrary.account.utils.RestPreconditions;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@CrossOrigin("*")
public class AccountController {

	private final AccountService accountService;

	@GetMapping("/account/{id}")
	public AccountDTO findById( @PathVariable() @NonNull Long id ){
		try {
			return RestPreconditions.checkFound( accountService.findById( id ) );
		} catch ( ResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "The account cannot be found", ex );
		}
	}
}

