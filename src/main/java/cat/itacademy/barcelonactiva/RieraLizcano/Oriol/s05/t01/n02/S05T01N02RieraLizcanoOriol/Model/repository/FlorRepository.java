package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.repository;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {
}
