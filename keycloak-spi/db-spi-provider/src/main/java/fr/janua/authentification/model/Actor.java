package fr.janua.authentification.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ACTOR", schema = "cerbere")
@NamedQueries({ @NamedQuery(name = "getUserByUsername", query = "select u from Actor u where u.username = :username"),
		@NamedQuery(name = "getUserByEmail", query = "select u from Actor u where u.email = :email") })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Actor {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "ID", length = 36)
	private String id;

	@Column(name = "TITLE", length = 20)
	private String title;

	@Column(name = "GENDER", length = 20)
	private String gender;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@ToString.Include
	@Column(name = "USERNAME", length = 20, nullable = false)
	private String username;

	@Column(name = "EMAIL", length = 150)
	private String email;

	@Column(name = "CREATION_DATE", columnDefinition = "timestamp without time zone", updatable = false)
	private java.sql.Timestamp creationDate;

	@Column(name = "ADDRESS", length = 150)
	private String address;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "COUNTRY", length = 5)
	private String country;

	@Column(name = "POSTAL_CODE", length = 15)
	private String postalCode;

	@Column(name = "PROVINCE", length = 100)
	private String province;

	@Column(name = "PASSWORD", length = 100)
	private String password;

	@Column(name = "PHONE_NUMBER", length = 20)
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ACTOR_ROLE", schema = "cerbere",
			joinColumns = @JoinColumn(name = "ACT_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ROL_ID", referencedColumnName = "ID"))
	private Set<CliRole> roles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ACTOR_GEO_GROUP", schema = "cerbere",
			joinColumns = @JoinColumn(name = "ACT_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "GRP_ID", referencedColumnName = "ID"))
	private Set<GeoGroup> groups = new HashSet<>();

}
