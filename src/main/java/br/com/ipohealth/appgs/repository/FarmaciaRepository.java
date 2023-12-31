package br.com.ipohealth.appgs.repository;

import br.com.ipohealth.appgs.entity.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}
