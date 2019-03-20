package pl.csanecki.AITSI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductType;
import pl.csanecki.AITSI.repository.ProductRepository;
import pl.csanecki.AITSI.repository.ProductTypeRepository;
import pl.csanecki.AITSI.util.NameFormatter;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductTypeRepository productTypeRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductTypeRepository productTypeRepository, ProductRepository productRepository) {
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductType> getAllCategories() {
        return productTypeRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(long categoryId) {
        ProductType productType = productTypeRepository.getByProductTypeId(categoryId);

        return productRepository.getProductByProductType(productType);
    }

    @Override
    public String getProductTypeNameWithFirstCapitalLetter(long categoryId) {
        ProductType productType = productTypeRepository.getByProductTypeId(categoryId);

        String returnName = NameFormatter.getNameWithFirstCapitalLetter(productType.getName());

        return returnName;
    }
}
