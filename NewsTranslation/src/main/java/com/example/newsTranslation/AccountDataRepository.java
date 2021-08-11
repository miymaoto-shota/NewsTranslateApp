package com.example.newsTranslation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends JpaRepository<AccountDataEntity, String> {
	// public AccountDataEntity findByName(String name);

	List<AccountDataEntity> findByName(String name);

	@SuppressWarnings("unchecked")
	AccountDataEntity save(AccountDataEntity accountDataEntity);
}