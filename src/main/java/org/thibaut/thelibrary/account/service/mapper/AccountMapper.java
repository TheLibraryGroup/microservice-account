package org.thibaut.thelibrary.account.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.thibaut.thelibrary.account.entity.AccountEntity;
import org.thibaut.thelibrary.account.service.dto.AccountDTO;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountMapper {

	AccountDTO userToDTO( AccountEntity accountEntity );

	List< AccountDTO > userToDTOList( List< AccountEntity > accountEntityList );

	AccountEntity userToEntity( AccountDTO accountDTO );

	List< AccountEntity > userToEntityList( List< AccountDTO > accountDTOList );

}
