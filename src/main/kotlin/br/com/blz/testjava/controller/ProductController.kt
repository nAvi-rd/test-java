package br.com.blz.testjava.controller

import br.com.blz.testjava.model.Product
import br.com.blz.testjava.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(@Autowired private val productService: ProductService) {

  @GetMapping("products/{sku}")
  fun getProductBySku(@PathVariable sku: Long): Product {
    return productService.getProductBySku(sku)
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("products")
  fun saveProduct(@RequestBody product: Product): Product {
    return productService.createProduct(product)
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PutMapping("products/{sku}")
  fun updateProduct(@PathVariable sku: Long, @RequestBody product: Product): Product {
    return productService.updateProduct(sku, product)
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("products/{sku}")
  fun deleteProduct(@PathVariable sku: Long) {
    productService.deleteProduct(sku)
  }
}
