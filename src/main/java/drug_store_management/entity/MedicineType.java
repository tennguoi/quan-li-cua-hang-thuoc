package drug_store_management.entity;

import jakarta.persistence.*;

@Entity
public class MedicineType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    public MedicineType() {}

    public MedicineType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}
