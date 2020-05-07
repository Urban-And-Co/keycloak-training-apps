package fr.janua.authentification.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "CLI_ROLE", schema = "cerbere")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class CliRole {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID", length = 36)
	private String id;

	@ToString.Include
	@Column(name = "CODE", length = 10, nullable = false)
	private String code;

	@ToString.Include
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLI_ID", referencedColumnName = "ID", updatable = true,
			foreignKey = @ForeignKey(name = "FK_ROL_CLI"))
	private Client client;

}
