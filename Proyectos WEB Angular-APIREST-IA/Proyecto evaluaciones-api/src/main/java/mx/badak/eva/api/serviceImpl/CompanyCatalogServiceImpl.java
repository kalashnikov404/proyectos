package mx.badak.eva.api.serviceImpl;


import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.CompanyCatalog;
import mx.badak.eva.api.repository.CompanyCatalogRepository;
import mx.badak.eva.api.service.CompanyCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyCatalogServiceImpl implements CompanyCatalogService {


    @Autowired
    private CompanyCatalogRepository companyRepository;

    @Override
    public CompanyCatalog createCompany(CompanyCatalog company) {

        return companyRepository.save(company);
    }

    @Override
    public List<CompanyCatalog> getCompanyAll() {
        return companyRepository.getCompanyAll();
    }


    @Override
    public void deleteCompany(Integer idCompanyCatalog) {

        companyRepository.deleteById(idCompanyCatalog);
    }


    @Override
    public CompanyCatalog updateCompany(Integer idCompanyCatalog, Integer status) {
        return companyRepository.findById(idCompanyCatalog).map(companie -> {
            companie.setStatus(status);
            return companyRepository.save(companie);
        }).orElseThrow(() -> new ResourceNotFound("id company " + idCompanyCatalog + " not found"));
    }


    @Override
    public Optional<CompanyCatalog> findById(Integer idCompanyCatalog) {
        return
                companyRepository.findById(idCompanyCatalog);
    }

    @Override
    public List<CompanyCatalog> findByNameLike(String letter) {

        return companyRepository.findByNameLike(letter);
    }

}


