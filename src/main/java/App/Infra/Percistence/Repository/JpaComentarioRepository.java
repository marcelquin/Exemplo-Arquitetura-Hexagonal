package App.Infra.Percistence.Repository;

import App.Infra.Percistence.Entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaComentarioRepository extends JpaRepository<ComentarioEntity,Long> {
}
