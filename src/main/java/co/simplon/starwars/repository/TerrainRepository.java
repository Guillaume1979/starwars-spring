package co.simplon.starwars.repository;

import co.simplon.starwars.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain,Integer> {
}
