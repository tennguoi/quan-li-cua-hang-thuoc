package drug_store_management.dto;

import drug_store_management.entity.Medicine.MedicineType;
import drug_store_management.entity.Medicine.Supplier;
import lombok.Data;

@Data
public class MedicineDTO {
    private Integer id;
    private String image;
    private String name;
    private MedicineType type;
    private String expiryDate;
    private Double price;
    private Integer stockQuantity;
    private Supplier supplier;
}
