package pl.puzzle.impact.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CompanyDetailsRepository extends JpaRepository<pl.puzzle.impact.company.CompanyDetails, Long> {}