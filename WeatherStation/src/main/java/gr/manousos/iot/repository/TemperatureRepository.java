package gr.manousos.iot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import gr.manousos.iot.domain.Temperature;

@RepositoryRestResource(collectionResourceRel = "temperature", path = "temperature")
public interface TemperatureRepository extends PagingAndSortingRepository<Temperature, Long> {

}
