package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.output.StaticInformationVO;
import com.frontier.back.lemon_tree.biz.vo.FlowRecordVO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import com.frontier.back.lemon_tree.data.dao.FlowRecordDAO;
import com.frontier.back.lemon_tree.data.entity.FlowRecord;
import com.frontier.back.lemon_tree.data.output.StaticInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowRecordDTOImpl implements FlowRecordDTO {
    @Autowired
    RecordDTO recordDTO;

    @Autowired
    NotesDTO notesDTO;

    @Autowired
    FlowRecordDAO flowRecordDAO;

    @Override
    public List<NotesVO> doneRecord(int idRecord) {
        recordDTO.doneRecord(idRecord);
        return notesDTO.getByIdRecord(idRecord);
    }

    @Override
    public void saveFlowRecord(FlowRecordVO flowRecordVO) {
        flowRecordDAO.saveFlowRecord(build(flowRecordVO));
        int idFlowRecord = flowRecordDAO.getIdFlowRecord(flowRecordVO.getIdRecord());
        notesDTO.addNote(flowRecordVO.getNote(), idFlowRecord);
    }

    @Override
    public List<StaticInformationVO> getStaticInformation(int idRecord) {
        return buildListStaticInformationVO(flowRecordDAO.getStaticInformation(idRecord));
    }


    public static FlowRecord build(FlowRecordVO flowRecordVO){
        if (flowRecordVO != null){
            FlowRecord flowRecord = new FlowRecord();
            flowRecord.setIdRecord(flowRecordVO.getIdRecord());
            flowRecord.setIdResponse(flowRecordVO.getIdResponse());
            flowRecord.setIdStep(flowRecordVO.getIdStep());
            flowRecord.setRespuestaEscrita(flowRecordVO.getRespuestaEscrita());
            flowRecord.setNote(flowRecordVO.getNote());

            return flowRecord;
        }
        return null;
    }

    public List<StaticInformationVO> buildListStaticInformationVO(List<StaticInformation> staticInformationList){
        if(staticInformationList != null){
            List<StaticInformationVO> voList = new ArrayList<>();
            staticInformationList.forEach(staticInformation -> voList.add(buildStaticInformationVO(staticInformation)));
        }
        return null;
    }

    public StaticInformationVO buildStaticInformationVO(StaticInformation staticInformation){
        if(staticInformation != null){
            StaticInformationVO staticInformationVO = new StaticInformationVO(staticInformation.getTitle(), staticInformation.getRespuestaEscrita());
            return staticInformationVO;
        }
        return null;
    }
}
