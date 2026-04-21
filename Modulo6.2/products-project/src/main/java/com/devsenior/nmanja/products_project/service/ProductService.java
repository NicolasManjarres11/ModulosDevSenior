package com.devsenior.nmanja.products_project.service;

import java.util.List;

import com.devsenior.nmanja.products_project.model.dto.ProductRequest;
import com.devsenior.nmanja.products_project.model.dto.ProductResponse;

public interface ProductService {
    
    //Obtener todos los productos
    List<ProductResponse> getAll();

    //Obtener producto por Id
    ProductResponse getBtId(String id);

    //Obtener producto por texto

    List<ProductResponse> searchByText(String search);

    //Obtener producto por tags

    List<ProductResponse> searchByTags(String tags);

    //Obtener producto por especificaciones

    List<ProductResponse> searchByspecifications(String key, String value);

    //Guardar producto
    ProductResponse save(ProductRequest product);

    //Actualizar producto
    ProductResponse update(String id, ProductRequest product);

    //Eliminar producto

    void delete(String id);

}
