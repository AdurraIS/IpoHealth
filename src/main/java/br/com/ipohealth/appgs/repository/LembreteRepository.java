package br.com.ipohealth.appgs.repository;

import br.com.ipohealth.appgs.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}
