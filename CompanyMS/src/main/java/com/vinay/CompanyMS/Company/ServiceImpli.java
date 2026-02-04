package com.vinay.CompanyMS.Company;

import com.vinay.CompanyMS.Company.Model.Company;
import com.vinay.CompanyMS.Company.Repository.CompanyRepo;
import com.vinay.CompanyMS.Company.Service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpli implements CompanyService {

    CompanyRepo companyRepo;

    public ServiceImpli(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public List<Company> gellAllComapnies() {
        return companyRepo.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepo.findById(id);

        if (companyOptional.isPresent()) {
          Company company1= companyOptional.get();
            // copy only updatable fields — do NOT change the id
            company1.setCompanyName(company.getCompanyName());
            company1.setDescription(company.getDescription());


            companyRepo.save(company1); // persist changes
            return true;
        }
        else return  false;

    }

    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public boolean deleteCompanyByID(Long id) {
        if(companyRepo.existsById(id)) {
            companyRepo.deleteById(id);
            return true;
        }
        else  return  false;
    }

    @Override
    public Company getCompanyByID( Long id) {
       return companyRepo.findById(id).orElse(null);
    }


}
