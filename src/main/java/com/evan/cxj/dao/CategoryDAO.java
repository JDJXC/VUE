package com.evan.cxj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.cxj.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
