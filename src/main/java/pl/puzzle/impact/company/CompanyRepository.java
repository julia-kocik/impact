package pl.puzzle.impact.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CompanyRepository extends JpaRepository<Company, UUID> {}