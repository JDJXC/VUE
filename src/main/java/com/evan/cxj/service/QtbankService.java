package com.evan.cxj.service;

import com.evan.cxj.dao.QtbankDAO;
import com.evan.cxj.pojo.Book;
import com.evan.cxj.pojo.QtCategory;
import com.evan.cxj.pojo.Qtbank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QtbankService {
    @Autowired
    QtbankDAO qtbankDAO;

    @Autowired
    QtCategoryService qtCategoryService;


    public List<Qtbank> Search(String keywords,int qid) {
        if (0 != qid) {
           // QtCategory qtCategory = qtCategoryService.get(qid);
            //System.out.print(qtCategory.getName());
            //return qtbankDAO.findAllByQtCategoryLikeOrTitleLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike(qtCategory, '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%');
          return qtbankDAO.MyfindBylikeAndQid('%' + keywords + '%',qid);

        } else {
            return qtbankDAO.findAllByTitleLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike('%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%');
            //return qtbankDAO.findAllByQidLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike(qid, '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%');
            //return qtbankDAO.find}
        }
    }
    public List<Qtbank> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return qtbankDAO.findAll();
    }

    public void addOrUpdate(Qtbank qtbank) {
        qtbankDAO.save(qtbank);
    }

    public List<Qtbank> listByCategory(int cid) {

            QtCategory qtCategory = qtCategoryService.get(cid);

            return qtbankDAO.findAllByQtCategory(qtCategory);

    }
}
