package com.vinay.CompanyMS.Company.Service;



import com.vinay.CompanyMS.Company.Model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> gellAllComapnies();
    boolean updateCompany(Company company,Long id);
    void createCompany(Company company);

    boolean deleteCompanyByID(Long id);
    Company getCompanyByID(Long id);
}
