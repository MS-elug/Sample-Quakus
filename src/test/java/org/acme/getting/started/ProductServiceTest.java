package org.acme.getting.started;

import org.acme.getting.started.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of {@link ProductService}.
 * It contains 4 unit test cases.
 */
public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        Product result = productService.addProduct(product);

        assertEquals(product, result);
    }

    /**
     * Test updating a product in the ProductService.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        productService.addProduct(product);

        Product updatedProduct = new Product();
        updatedProduct.setId("p1");
        updatedProduct.setName("Updated Product 1");
        updatedProduct.setDescription("Updated Description of Product 1");
        updatedProduct.setPrice(15.0);

        Product result = productService.updateProduct("p1", updatedProduct);

        assertEquals(updatedProduct, result);
        assertEquals("Updated Product 1", productService.getProduct("p1").getName());
    }

    /**
     * Test getting a product by ID in the ProductService.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testGetProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        productService.addProduct(product);

        Product result = productService.getProduct("p1");

        assertEquals(product, result);
    }

    /**
     * Test getting a product by ID that does not exist in the ProductService.
     * @TedAIGenerated 20240606180559
     */
    @Test
    public void testGetNonExistentProduct() {
        Product result = productService.getProduct("non-existent-id");

        assertNull(result);
    }
}