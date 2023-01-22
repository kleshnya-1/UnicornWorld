package repository;

import model.entity.animal.UnicornEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnicornRepository extends PagingAndSortingRepository<UnicornEntity, String> {




}
