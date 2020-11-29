package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.NotesDTO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import javax.ws.rs.core.Context;
import java.util.List;

@RestController
@RequestMapping("/flow-record")
public class NotesWS {
    @Autowired
    private NotesDTO notesDTO;

    @RequestMapping("/{idRecord}")
    public List<NotesVO> getByIdRecord(@PathVariable int idRecord){
        return notesDTO.getByIdRecord(idRecord);
    }
}
