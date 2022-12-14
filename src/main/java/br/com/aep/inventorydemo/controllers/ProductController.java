package br.com.aep.inventorydemo.controllers;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.Response;
import br.com.aep.inventorydemo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.aep.inventorydemo.service.IProductService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductRepository productRepository;


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
    public ResponseEntity<Response<ProductData>> findById(@PathVariable("id") Long id) {
        Response<ProductData> response = new Response<>();
        response.setData(this.productService.buscaPorId(id));
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findStock")
    public ResponseEntity<Response<List<ProductData>>> findStock() {
        Response<List<ProductData>> response = new Response<>();
        response.setData(this.productService.findStock());
        response.setStatusCode(HttpStatus.OK.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Response<List<ProductData>>> findAll() {
        Response<List<ProductData>> response = new Response<>();
        response.setData(this.productService.findAll());
        response.setStatusCode(HttpStatus.OK.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<Response<ProductData>> atualizarProduct(@RequestBody ProductData productData){
        Response<ProductData> response = new Response<>();
        response.setData(this.productService.atualizarProduto(productData));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<Response<List<ProductModel>>> findByCategoryName(@RequestParam String category) {
        Response<List<ProductModel>> response = new Response<>();
        response.setData(this.productService.allProductsByCategory(category));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByProvider")
    public ResponseEntity<Response<List<ProductModel>>> findByProviderName(@RequestParam String provider) {
        Response<List<ProductModel>> response = new Response<>();
        response.setData(this.productService.allProductByProvider(provider));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}
