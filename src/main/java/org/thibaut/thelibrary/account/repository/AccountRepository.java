package org.thibaut.thelibrary.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.account.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository< AccountEntity, Long > {

	AccountEntity findByUserName( String username );

	AccountEntity findByEmail( @Param( "email" ) String email );

}
