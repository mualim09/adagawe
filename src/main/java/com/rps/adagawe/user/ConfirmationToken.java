package com.rps.adagawe.user;

import com.rps.adagawe.model.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class ConfirmationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "confirmation_token")
	private String confirmationToken;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@OneToOne(targetEntity = UserLogin.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_user")
	private UserLogin user;

	ConfirmationToken(UserLogin user) {
		this.user = user;
		this.createdDate = LocalDate.now();
		this.confirmationToken = UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return "ConfirmationToken{" +
				"id=" + id +
				", confirmationToken='" + confirmationToken + '\'' +
				", createdDate=" + createdDate +
				", user=" + user +
				'}';
	}
}