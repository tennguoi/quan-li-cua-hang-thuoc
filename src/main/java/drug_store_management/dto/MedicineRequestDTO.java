package drug_store_management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import drug_store_management.entity.Medicine;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineRequestDTO {

    private Integer id;

    @NotBlank(message = "Image URL cannot be empty")
    private String image;

    private MultipartFile imageFile;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Type cannot be empty")
    private String type;

    private LocalDate expiryDate;

    @NotNull(message = "Price cannot be empty")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than or equal to 0")
    private BigDecimal price;

    @NotNull(message = "Stock quantity cannot be empty")
    @Min(value = 0, message = "Stock quantity must be greater than or equal to 0")
    private Integer stockQuantity;

    @NotBlank(message = "Supplier cannot be empty")
    private String supplier;

    // Convert to Thuoc entity
    public Medicine toEntity() {
        Medicine medicine = new Medicine();
        medicine.setId(this.id);
        medicine.setImage(this.image);
        medicine.setName(this.name);
        medicine.setType(this.type);
        medicine.setExpiryDate(this.expiryDate);
        medicine.setPrice(this.price);
        medicine.setStockQuantity(this.stockQuantity);
        medicine.setSupplier(this.supplier);
        return medicine;
    }

    // Create from Thuoc entity
    public static MedicineRequestDTO fromEntity(Medicine medicine) {
        MedicineRequestDTO dto = new MedicineRequestDTO();
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
}