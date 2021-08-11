package com.example.newsTranslation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDataService {
	@Autowired
	private AccountDataRepository repository;

	public AccountDataEntity findByName(String name) {
		List<AccountDataEntity> accountDataEntity = repository.findByName(name);

		return accountDataEntity.get(0);
	}

	public void save(AccountDataEntity saveData) {
		repository.save(saveData);
	}
}
