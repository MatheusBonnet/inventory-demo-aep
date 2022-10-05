package br.com.aep.inventorydemo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aep.inventorydemo.model.CategoryModel;
import br.com.aep.inventorydemo.model.Response;
import br.com.aep.inventorydemo.repository.ICategoryRepository;
import br.com.aep.inventorydemo.service.ICategoryService;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@PostMapping()
    public ResponseEntity<Response<CategoryModel>> salvar(@RequestBody CategoryModel categoryModel) {
        Response<CategoryModel> response = new Response<>();
        response.setData(this.categoryService.saveCategory(categoryModel));
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
    }
	
	@GetMapping()
    public ResponseEntity<List<CategoryModel>> findAllCategory() {
        return ResponseEntity.ok(this.categoryRepository.findAll());
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<CategoryModel>> findById(@PathVariable final Long id){
			Response<CategoryModel> response = new Response<>();
	        response.setData(this.categoryService.buscaPorId(id));
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setTimeStamp(new Date().getTime());
	        return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<CategoryModel>> delete(@PathVariable final Long id){
		Response<CategoryModel> response = new Response<>();
        this.categoryService.excluiCategoria(id);
        response.setStatusCode(HttpStatus.OK.value());
        response.setTimeStamp(new Date().getTime());
        return ResponseEntity.ok(response);
}
	
}
