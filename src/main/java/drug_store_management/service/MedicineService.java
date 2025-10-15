package drug_store_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drug_store_management.dto.MedicineDTO;
import drug_store_management.entity.Medicine;
import drug_store_management.repository.MedicineRepository;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<MedicineDTO> getAllMedicines() {
        return medicineRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MedicineDTO getMedicineById(Integer id) {
        return medicineRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    public MedicineDTO createMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = convertToEntity(medicineDTO);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return convertToDTO(savedMedicine);
    }

    public MedicineDTO updateMedicine(Integer id, MedicineDTO medicineDTO) {
        Medicine existingMedicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
        
        existingMedicine.setImage(medicineDTO.getImage());
        existingMedicine.setName(medicineDTO.getName());
        existingMedicine.setType(medicineDTO.getType());
        existingMedicine.setExpiryDate(medicineDTO.getExpiryDate());
        existingMedicine.setPrice(medicineDTO.getPrice());
        existingMedicine.setStockQuantity(medicineDTO.getStockQuantity());
        existingMedicine.setSupplier(medicineDTO.getSupplier());

        Medicine updatedMedicine = medicineRepository.save(existingMedicine);
        return convertToDTO(updatedMedicine);
    }

    public void deleteMedicine(Integer id) {
        if (!medicineRepository.existsById(id)) {
            throw new RuntimeException("Medicine not found");
        }
        medicineRepository.deleteById(id);
    }

    private MedicineDTO convertToDTO(Medicine medicine) {
        MedicineDTO dto = new MedicineDTO();
        dto.setId(medicine.getId());
        dto.setImage(medicine.getImage());
        dto.setName(medicine.getName());
        dto.setType(medicine.getType());
        dto.setExpiryDate(medicine.getExpiryDate());
        dto.setPrice(medicine.getPrice());
        dto.setStockQuantity(medicine.getStockQuantity());
        dto.setSupplier(medicine.getSupplier());
        return dto;
    }

    private Medicine convertToEntity(MedicineDTO dto) {
        return Medicine.builder()
                .image(dto.getImage())
                .name(dto.getName())
                .type(dto.getType())
                .expiryDate(dto.getExpiryDate())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .supplier(dto.getSupplier())
                .build();
    }
}
