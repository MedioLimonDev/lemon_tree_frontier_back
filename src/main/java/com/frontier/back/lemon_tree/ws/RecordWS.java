package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class RecordWS {
    @Autowired
    private RecordDTO recordDTO;

    @PostMapping("/{idEmployee}")
    public int addRecord(@PathVariable("idEmployee") int idEmployee){
        recordDTO.addRecord(idEmployee);
        return recordDTO.getRecord(idEmployee);
    }
}
