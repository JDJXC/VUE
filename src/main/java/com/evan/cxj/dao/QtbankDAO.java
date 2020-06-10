package com.evan.cxj.dao;


import com.evan.cxj.pojo.Book;
import com.evan.cxj.pojo.QtCategory;
import com.evan.cxj.pojo.Qtbank;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QtbankDAO extends JpaRepository<Qtbank,Integer> {

    List <Qtbank> findAllByTitleLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike(String keyword1, String keyword2, String keyword3, String keyword4, String keyword5);
    List<Qtbank> findAllByQtCategory(QtCategory qtCategory);

    List<Qtbank> findAllByQtCategoryLikeOrTitleLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike(QtCategory qtCategory, String s, String s1, String s2, String s3, String s4);
    @Query(value = "select * from qtbank q where (q.title like :keyword or q.opa like :keyword or q.opb like :keyword or q.opc like :keyword  or q.opd like :keyword) and q.qid=:qid", nativeQuery = true)
    List<Qtbank> MyfindBylikeAndQid(String keyword,int qid);
    //List<Qtbank> findAllByQidLikeOrOpaLikeOrOpbLikeOrOpcLikeOrOpdLike( int n, String s1, String s2, String s3, String s4);
}
