package org.thibaut.thelibrary.account.helper;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.account.entity.AccountEntity;
import org.thibaut.thelibrary.account.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbPopulator implements CommandLineRunner {


	private final AccountRepository accountRepository;

	@Override
	public void run( String... args ) throws Exception {
//		deleteAllThenPopulate( );
	}

	private void deleteAllThenPopulate( ) {

		System.out.println( "CONSUMER APP RUN" );

		//-----CLEAN DB
		this.accountRepository.deleteAll();

		//-----POPULATE USERS
		List< AccountEntity > userEntities = new ArrayList<>(  );

		//pwd = 1235
		userEntities.add( AccountEntity.builder()
				                  .firstName( "John" )
				                  .lastName( "Doe" )
				                  .userName( "TheJohn" )
				                  .email( "john@gmail.com" )
				                  .registrationDate( DateTime.now() )
				                  .build());

		//-----SAVE ALL USERS
		this.accountRepository.saveAll( userEntities );

	}
}
