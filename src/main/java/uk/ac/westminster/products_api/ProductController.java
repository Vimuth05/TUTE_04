package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // Add a new digital product
    @PostMapping
    public Product addProduct(@RequestBody DigitalProduct product) {
        // Product is abstract, so use DigitalProduct.
        return productService.addProduct(product);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Search products by name
    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    // Get all product summaries
    @GetMapping("/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }
}
