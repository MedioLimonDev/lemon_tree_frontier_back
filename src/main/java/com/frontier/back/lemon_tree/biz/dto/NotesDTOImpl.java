package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import com.frontier.back.lemon_tree.data.dao.NotesDAO;
import com.frontier.back.lemon_tree.data.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesDTOImpl implements NotesDTO {
    @Autowired
    NotesDAO notesDAO;

    public List<NotesVO> getByIdRecord(int idRecord){
        return buildListVO(notesDAO.getByIdRecord(idRecord));
    }

    @Override
    public void addNote(String note, int id_flow_record){
        notesDAO.addNote(note, id_flow_record);
    }

    public static NotesVO buildVO(Notes notes){
        if(notes != null){
            NotesVO notesVO = new NotesVO();
            notesVO.setStepTitle(notes.getStepTitle());
            notesVO.setResponseQuestion(notes.getResponseQuestion());
            notesVO.setDescription(notes.getDescription());

            return notesVO;
        }

        return null;
    }

    public static List<NotesVO> buildListVO(List<Notes> list){
        if (list != null){
            List<NotesVO> notesVOList = new ArrayList<>();
            list.forEach(n -> notesVOList.add(buildVO(n)));

            return notesVOList;
        }
        return null;
    }

}
