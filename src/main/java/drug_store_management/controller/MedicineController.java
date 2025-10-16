package drug_store_management.controller;

import drug_store_management.dto.MedicineRequestDTO;
import drug_store_management.entity.Medicine;
import drug_store_management.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/medicine") // Giữ @RequestMapping gốc để tổ chức cấu trúc
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @PostMapping("/add") 
    public ResponseEntity<MedicineRequestDTO> addMedicine(@Valid @ModelAttribute MedicineRequestDTO medicineDTO) throws IOException {
        Medicine medicine = medicineDTO.toEntity();
        Medicine savedMedicine = medicineService.addMedicine(medicine, medicineDTO.getImageFile());
        return ResponseEntity.ok(MedicineRequestDTO.fromEntity(savedMedicine));
    }
}