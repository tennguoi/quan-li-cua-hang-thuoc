package drug_store_management.repository;

import drug_store_management.entity.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineTypeRepository extends JpaRepository<MedicineType, Long> {
}
