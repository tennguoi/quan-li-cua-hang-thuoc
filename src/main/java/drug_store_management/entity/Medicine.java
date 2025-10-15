package drug_store_management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "medicine") // Cập nhật tên bảng
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Image URL cannot be empty")
    @Column(name = "image", nullable = false)
    private String image;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Type cannot be empty")
    @Column(name = "type", nullable = false)
    private String type; // Sử dụng String thay ENUM để linh hoạt (có thể dùng @Enumerated nếu cần)

    @Column(name = "expiry_date")
    private LocalDate expiryDate; // Cập nhật tên và loại

    @NotNull(message = "Price cannot be empty")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than or equal to 0")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull(message = "Stock quantity cannot be empty")
    @Min(value = 0, message = "Stock quantity must be greater than or equal to 0")
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @NotBlank(message = "Supplier cannot be empty")
    @Column(name = "supplier", nullable = false)
    private String supplier; // Sử dụng String thay ENUM để linh hoạt
}