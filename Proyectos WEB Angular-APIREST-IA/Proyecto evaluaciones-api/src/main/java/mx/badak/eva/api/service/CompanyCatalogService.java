package mx.badak.eva.api.service;

import mx.badak.eva.api.model.CompanyCatalog;

import java.util.List;
import java.util.Optional;

public interface CompanyCatalogService {


    CompanyCatalog createCompany(CompanyCatalog company);

    List<CompanyCatalog> getCompanyAll();

    void deleteCompany(Integer idCompanyCatalog);

    public CompanyCatalog updateCompany(Integer idCompanyCatalog, Integer status);

    Optional<CompanyCatalog> findById(Integer idCompanyCatalog);

    List<CompanyCatalog> findByNameLike(String letter);
}

