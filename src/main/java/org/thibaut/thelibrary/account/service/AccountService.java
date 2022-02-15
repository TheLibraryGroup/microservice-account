package org.thibaut.thelibrary.account.service;


import org.thibaut.thelibrary.account.service.dto.AccountDTO;

import java.util.List;

public interface AccountService {


	List< AccountDTO > findAll( );

	void delete( Long id );

	AccountDTO findOne( String username );

	AccountDTO findById( Long id );

	AccountDTO update( AccountDTO accountDto );

//	UserDTO save( UserDTO user );
//
//	UserEntity findByUserName( String username );
//
//	UserEntity findByEmail( String email );
}
