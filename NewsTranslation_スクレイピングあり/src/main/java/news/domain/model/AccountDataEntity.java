package news.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountlist")
public class AccountDataEntity {
	@Id
	@Column(name = "user_Name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	public AccountDataEntity() {
	}

	public AccountDataEntity(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
