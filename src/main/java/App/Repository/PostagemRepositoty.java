package App.Repository;

import App.Entity.PostagemEntity;
import org.hibernate.query.criteria.JpaFetchParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepositoty extends JpaRepository<PostagemEntity,Long> {
}
