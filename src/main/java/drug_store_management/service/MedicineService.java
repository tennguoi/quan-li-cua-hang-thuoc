package drug_store_management.service;

import drug_store_management.entity.Medicine;
import drug_store_management.entity.MedicineType;
import drug_store_management.entity.Supplier;
import drug_store_management.repository.MedicineRepository;
import drug_store_management.repository.MedicineTypeRepository;
import drug_store_management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineTypeRepository medicineTypeRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    // Lấy danh sách loại thuốc (hiển thị dropdown)
    public List<MedicineType> getAllMedicineTypes() {
        return medicineTypeRepository.findAll();
    }

    // Lấy danh sách nhà cung cấp (hiển thị dropdown)
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Lưu thuốc mới vào database
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }
}
