package news.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import news.domain.model.NewsDataEntity;

public interface NewsDataRepository extends JpaRepository<NewsDataEntity, Integer> {
	List<NewsDataEntity> findAll();

	@SuppressWarnings("unchecked")
	NewsDataEntity save(NewsDataEntity newsDataEntity);
}
