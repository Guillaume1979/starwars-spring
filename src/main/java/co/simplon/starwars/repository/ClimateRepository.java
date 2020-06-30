package co.simplon.starwars.repository;

import co.simplon.starwars.model.Climate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends JpaRepository<Climate,Integer> {
}
