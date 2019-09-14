package piyush.tcs.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import piyush.tcs.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
