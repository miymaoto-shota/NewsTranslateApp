package news.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountlist")
public class AccountDataEntity {
	@Id
	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	public AccountDataEntity() {
	}

	public AccountDataEntity(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
}
