package br.com.aep.inventorydemo.controllers;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.EmployeeModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import br.com.aep.inventorydemo.constants.InventoryDemoConstants;
import br.com.aep.inventorydemo.exception.ProductException;
import br.com.aep.inventorydemo.service.IProductService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/items")
public class ProductController {

    @Autowired
    private IProductService productService;


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.productService.inativarProduto(id);
        ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Response<ProductModel>> saveItem(@RequestBody ProductData productData) {
        Response<ProductModel> response = new Response<>();
        response.setData(this.productService.saveProduct(productData));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProductModel>> findById(@PathVariable("id") Long id) {
        Response<ProductModel> response = new Response<>();
        response.setData(this.productService.buscaPorId(null));
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findStock")
    public ResponseEntity<Response<List<ProductModel>>> findStock() {
        Response<List<ProductModel>> response = new Response<>();
        response.setData(this.productService.findStock());
        response.setStatusCode(HttpStatus.OK.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<ProductModel>> atualizarUser(@PathVariable("id") Long id, @RequestBody ProductData productData){
        Response<ProductModel> response = new Response<>();
        response.setData(this.productService.atualizarProduto(id, productData));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}
