package App.Infra.Percistence.Repository;

import App.Infra.Percistence.Entity.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostagemRepositoty extends JpaRepository<PostagemEntity,Long> {
}
