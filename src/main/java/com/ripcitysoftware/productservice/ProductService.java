package com.ripcitysoftware.productservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.Instant;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findProduct(Long id) {
        return productRepository.findById(id);
    }
}

@Repository
interface ProductRepository extends JpaRepository<Product, Long> {}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@JsonIgnoreProperties
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String gtin;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "label_description")
    private String labelDescription;
    @Column(name = "medium_image_url")
    private String mediumImageUrl;
}
