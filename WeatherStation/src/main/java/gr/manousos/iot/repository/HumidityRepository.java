package gr.manousos.iot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gr.manousos.iot.domain.Humidity;

@RepositoryRestResource(collectionResourceRel = "humidity", path = "humidity")
public interface HumidityRepository extends PagingAndSortingRepository<Humidity, Long> {

}
