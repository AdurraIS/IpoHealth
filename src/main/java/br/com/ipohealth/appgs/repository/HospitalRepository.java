package br.com.ipohealth.appgs.repository;

import br.com.ipohealth.appgs.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
