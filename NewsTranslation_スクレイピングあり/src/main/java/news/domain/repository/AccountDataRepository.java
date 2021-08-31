package news.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import news.domain.model.AccountDataEntity;

public interface AccountDataRepository extends JpaRepository<AccountDataEntity, String> {
	AccountDataEntity findByUserName(String userName);

	@SuppressWarnings("unchecked")
	AccountDataEntity save(AccountDataEntity accountDataEntity);
}