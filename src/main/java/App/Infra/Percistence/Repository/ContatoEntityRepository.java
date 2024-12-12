package App.Infra.Percistence.Repository;

import App.Infra.Percistence.Entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoEntityRepository extends JpaRepository<ContatoEntity,Long> {

}
