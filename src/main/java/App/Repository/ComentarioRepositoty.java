package App.Repository;

import App.Entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepositoty extends JpaRepository<ComentarioEntity,Long> {
}
