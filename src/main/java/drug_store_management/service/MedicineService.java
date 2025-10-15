package drug_store_management.service;

import drug_store_management.entity.Medicine;
import drug_store_management.repository.MedicineRepository;
import drug_store_management.config.FileUploadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private FileUploadConfig fileUploadConfig;


}