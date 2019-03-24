package pl.csanecki.AITSI.service;

import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductCount;
import pl.csanecki.AITSI.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<ProductType> getAllCategories();
    List<Product> getProductsByCategory(long categoryId);
    String getProductTypeNameWithFirstCapitalLetter(long categoryId);
    Product getProductById(long id);
    Product getProductByProducerAndModel(String producer, String model);
    void saveProduct(Product product);
    ProductCount getProductCountByProductId(long id);
}
