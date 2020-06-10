package com.evan.cxj.service;

import com.evan.cxj.dao.QtCategoryDAO;
import com.evan.cxj.pojo.QtCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QtCategoryService {
    @Autowired
    QtCategoryDAO qtCategoryDAO;

    public QtCategory get(int id) {
        QtCategory c=qtCategoryDAO.findById(id).orElse(null);
        return c;
    }
}
