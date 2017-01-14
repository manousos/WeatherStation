package gr.manousos.iot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import gr.manousos.iot.domain.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

}
