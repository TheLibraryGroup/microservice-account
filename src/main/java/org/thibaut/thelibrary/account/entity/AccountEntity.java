package org.thibaut.thelibrary.account.entity;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name="user_generator", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
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
