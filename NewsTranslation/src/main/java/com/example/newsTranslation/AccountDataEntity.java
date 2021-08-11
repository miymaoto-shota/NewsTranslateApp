package com.example.newsTranslation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accountlist")
public class AccountDataEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String name;

	private String password;
}
