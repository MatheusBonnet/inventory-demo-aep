package br.com.aep.inventorydemo.controllers;

import br.com.aep.inventorydemo.data.ProductData;
import br.com.aep.inventorydemo.data.ProviderData;
import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.ProductModel;
import br.com.aep.inventorydemo.model.ProviderModel;
import br.com.aep.inventorydemo.model.Response;
import br.com.aep.inventorydemo.service.IProductService;
import br.com.aep.inventorydemo.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/providers")
public class ProviderController {

    @Autowired
    private IProviderService iProviderService;


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.iProviderService.excluiProvider(id);
        ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Response<ProviderModel>> saveItem(@RequestBody ProviderModel providerModel) {
        Response<ProviderModel> response = new Response<>();
        response.setData(this.iProviderService.saveProvider(providerModel));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProviderModel>> findById(@PathVariable("id") Long id) {
        Response<ProviderModel> response = new Response<>();
        response.setData(this.iProviderService.buscaPorId(id));
        response.setStatusCode(HttpStatus.FOUND.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allProviderNames")
    public ResponseEntity<Response<List<String>>> allProviderNames() {
        Response<List<String>> response = new Response<>();
        response.setData(this.iProviderService.allByname());
        response.setStatusCode(HttpStatus.OK.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<ProviderModel>> atualizarProvider(@PathVariable("id") Long id, @RequestBody ProviderData providerData){
        Response<ProviderModel> response = new Response<>();
        response.setData(this.iProviderService.atualizarProvider(id, providerData));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}
