package org.thibaut.thelibrary.account.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.account.exception.ResourceNotFoundException;
import org.thibaut.thelibrary.account.repository.AccountRepository;
import org.thibaut.thelibrary.account.service.dto.AccountDTO;
import org.thibaut.thelibrary.account.service.mapper.AccountMapper;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final AccountMapper accountMapper;


	@Override
	public List< AccountDTO > findAll( ) {
		return Optional.of( accountMapper.userToDTOList( accountRepository.findAll() )).orElseThrow( ResourceNotFoundException::new );
	}

	@Override
	public void delete( Long id ) {
		accountRepository.deleteById(id);
	}

	@Override
	public AccountDTO findOne( String username ) {
		return accountMapper.userToDTO( accountRepository.findByUserName(username));
	}

	@Override
	public AccountDTO findById( Long id ) {
		return accountMapper.userToDTO( accountRepository.findById( id ).orElseThrow( ResourceNotFoundException::new  ));
	}

	@Override
	public AccountDTO update( AccountDTO accountDto ) {

		final Optional< AccountDTO > optionalUserDTO = Optional.of( accountDto );
		optionalUserDTO.ifPresent( accountDTO -> accountRepository.save( accountMapper.userToEntity( accountDTO ) ) );
		return optionalUserDTO.orElseThrow( ResourceNotFoundException::new );
	}


//	@Override
//	public UserDTO save( UserDTO user ) {
//		final Optional< UserDTO > optionalUserDTO = Optional.of( user );
//		optionalUserDTO.ifPresent( userDTO -> userRepository.save( UserEntity.builder()
//			                                        .userName( user.getUserName() )
//													.firstName( user.getFirstName() )
//													.lastName( user.getLastName() )
//													.registrationDate( DateTime.now() )
//													.password( bCryptPasswordEncoder.encode(user.getPassword()) )
//												.build()));
//		return optionalUserDTO.orElseThrow( ResourceNotFoundException::new );
//	}
//
//
//	@Override
//	public UserEntity findByUserName( String username ) {
//		UserEntity userEntity = userRepository.findByUserName( username );
//		userEntity.setRoleList( roleRepository.getRolesByUsername( username ) );
//
//		return userEntity;
//	}
//
//
//	@Override
//	public UserEntity findByEmail( String email ) {
//		UserEntity userEntity = userRepository.findByEmail( email );
//		userEntity.setRoleList( roleRepository.getRolesByEmail( email ) );
//
//		return userEntity;
//	}
}
