package news.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import news.domain.model.AccountDataEntity;
import news.domain.repository.AccountDataRepository;

@Service
public class AccountDataService {
	@Autowired
	AccountDataRepository accountDataRepository;

	/** ユーザ名から検索 */
	public AccountDataEntity getName(String name) {
		return accountDataRepository.findByUserName(name);
	}

	/** 追加 */
	public void addAccount(String name, String password, String role) {
		AccountDataEntity accountDataEntity = new AccountDataEntity(name, password, role);
		accountDataRepository.save(accountDataEntity);
	}
}
