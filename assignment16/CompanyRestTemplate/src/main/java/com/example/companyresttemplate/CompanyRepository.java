package com.example.companyresttemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("SELECT c.name FROM Company c where c.id = :id")
    String getCompanyNameById(@Param(value = "id") Long id);
}
