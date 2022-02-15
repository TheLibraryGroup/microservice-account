package org.thibaut.thelibrary.account.service.dto;

import lombok.*;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountDTO {

	private Long id;

	private String firstName;
	private String lastName;
	private String userName;
	private DateTime registrationDate;

	private String street;
	private String streetNumber;
	private String additionalInformation;
	private String city;
	private Long postalCode;
	private String phone;
	private String email;

}
