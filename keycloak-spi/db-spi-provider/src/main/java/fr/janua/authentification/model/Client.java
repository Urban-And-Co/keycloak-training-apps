package fr.janua.authentification.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT", schema = "cerbere")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Client {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID", length = 36)
	private String id;

	@ToString.Include
	@Column(name = "CODE", length = 10, nullable = false)
	private String code;

	@ToString.Include
	@Column(name = "NAME", length = 100, nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", length = 255)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<CliRole> roles = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<GeoGroup> groups = new HashSet<>();

}
