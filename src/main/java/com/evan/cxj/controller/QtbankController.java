package com.evan.cxj.controller;


import com.evan.cxj.pojo.Book;
import com.evan.cxj.pojo.Qtbank;
import com.evan.cxj.service.QtbankService;
import com.evan.cxj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
public class QtbankController {
    @Autowired
    QtbankService qtbankService;

    @CrossOrigin
    @GetMapping("api/searchqt/{qid}")
    public List<Qtbank> searchResult(@RequestParam("keywords") String keywords,@PathVariable("qid") int qid) throws Exception{
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return qtbankService.list();
        } else {
            return qtbankService.Search(keywords,qid);
        }
    }

    @CrossOrigin
    @PostMapping("api/addorupqt")
    public Qtbank addOrUpdate(@RequestBody Qtbank qtbank) throws Exception {
        qtbankService.addOrUpdate(qtbank);
        return qtbank;
    }

    @CrossOrigin
    @GetMapping("/api/categories/{qid}/qtbanks")
    public List<Qtbank> listByCategory(@PathVariable("qid") int qid) throws Exception {
        if (0 != qid) {
            return qtbankService.listByCategory(qid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/qtbanks")
    private List<Qtbank> list() throws Exception{
        return qtbankService.list();
    }

}
