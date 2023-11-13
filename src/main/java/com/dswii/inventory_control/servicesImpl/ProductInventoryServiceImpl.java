package com.dswii.inventory_control.servicesImpl;

import com.dswii.inventory_control.entities.ProductInventory;
import com.dswii.inventory_control.enums.Status;
import com.dswii.inventory_control.repositories.ProductInventoryRepository;
import com.dswii.inventory_control.services.ProductInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductInventoryServiceImpl implements ProductInventoryService {
    private final ProductInventoryRepository productInventoryRepository;

    @Override
    public List<ProductInventory> findAll() throws Exception {
        try {
            return productInventoryRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ProductInventory> findAllActive() throws Exception {
        try {
            return productInventoryRepository
                    .findAll()
                    .stream()
                    .filter(productInventory -> productInventory.getStatus() == Status.ACTIVE)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProductInventory findById(Long id) throws Exception {
        try {
            return productInventoryRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProductInventory save(ProductInventory productInventory) throws Exception {
        try {
            return productInventoryRepository.save(productInventory);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProductInventory update(Long id, ProductInventory productInventory) throws Exception {
        try {
            boolean isPresent = productInventoryRepository.findById(id).isPresent();
            return isPresent ? productInventoryRepository.save(productInventory) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ProductInventory delete(Long id) throws Exception {
        try {
            Optional<ProductInventory> optionalProductInventory = productInventoryRepository.findById(id);

            if (optionalProductInventory.isPresent()) {
                ProductInventory productInventory = optionalProductInventory.get();
                productInventory.setStatus(Status.INACTIVE);
                return productInventoryRepository.save(productInventory);
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
