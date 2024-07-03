package CountryApi.Repositories;

import CountryApi.domain.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryInfoRepository extends JpaRepository<CountryInfo, Long> {


     CountryInfo findBysName(String sName);
}
