package pl.puzzle.impact.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserCompanyRepository extends JpaRepository<UserCompany, Long> {}
