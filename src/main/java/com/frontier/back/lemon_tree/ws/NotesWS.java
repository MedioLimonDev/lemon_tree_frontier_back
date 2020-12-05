package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.NotesDTO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import com.frontier.back.lemon_tree.biz.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesWS {
    @Autowired
    private NotesDTO notesDTO;

    @PostMapping("/getByIdRecord")
    public Response getByIdRecord(@RequestBody RecordVO recordVO){
        List<NotesVO> responseNotes =  notesDTO.getByIdRecord(recordVO.getId());

        return Response.status(Response.Status.OK)
                .entity(responseNotes)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
