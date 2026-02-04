package com.vinay.CompanyMS.Company.Controller;

import com.vinay.CompanyMS.Company.Model.Company;
import com.vinay.CompanyMS.Company.Service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllComapanies(){
        return new ResponseEntity<>(companyService.gellAllComapnies(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateComapanies(@PathVariable Long id,@RequestBody Company company){
        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createComapanies(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created Successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean isDeleted=companyService.deleteCompanyByID(id);
        if(isDeleted)
          return  new ResponseEntity<>("Company Deleted Successfully",HttpStatus.OK);
        else {
            return new ResponseEntity<>("Company NotFound ",HttpStatus.NOT_FOUND);
        }
    }
@GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company=companyService.getCompanyByID(id);
        if(company!= null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }else{
               return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}
}
