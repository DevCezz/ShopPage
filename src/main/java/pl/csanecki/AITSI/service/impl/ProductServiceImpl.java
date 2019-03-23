package pl.csanecki.AITSI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.csanecki.AITSI.entity.Product;
import pl.csanecki.AITSI.entity.ProductCount;
import pl.csanecki.AITSI.entity.ProductType;
import pl.csanecki.AITSI.repository.ProductCountRepository;
import pl.csanecki.AITSI.repository.ProductRepository;
import pl.csanecki.AITSI.repository.ProductTypeRepository;
import pl.csanecki.AITSI.service.ProductService;
import pl.csanecki.AITSI.util.NameFormatter;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductTypeRepository productTypeRepository;
    private ProductRepository productRepository;
    private ProductCountRepository productCountRepository;

    @Autowired
    public ProductServiceImpl(ProductTypeRepository productTypeRepository, ProductRepository productRepository,
    		ProductCountRepository productCountRepository) {
        this.productTypeRepository = productTypeRepository;
        this.productRepository = productRepository;
        this.productCountRepository = productCountRepository;
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

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductByProductId(id);
    }

	@Override
	public ProductCount getProductCountByProductId(long id) {
		return productCountRepository.getProductCountByProductId(id);
	}
}
