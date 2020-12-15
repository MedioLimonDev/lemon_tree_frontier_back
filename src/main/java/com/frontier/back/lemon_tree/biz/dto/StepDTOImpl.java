package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.StepVO;
import com.frontier.back.lemon_tree.data.dao.StepDAO;
import com.frontier.back.lemon_tree.data.entity.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepDTOImpl implements StepDTO {
    @Autowired
    private StepDAO stepDAO;

    //@Override
    public StepVO getLastAnswer(StepVO stepVO){
        return new StepVO();
    }

    @Override
    public StepVO getStep(int idNextStep){
        return buildVO(stepDAO.getStep(idNextStep));
    }

    private StepVO buildVO(Step step){
        if(step != null){
            StepVO stepVO = new StepVO();

            stepVO.setId(step.getId());
            stepVO.setTitle(step.getTitle());
            stepVO.setDescription(step.getDescription());
            stepVO.setAgentActivity(step.getAgentActivity());
            stepVO.setCustomerActivity(step.getCustomerActivity());
            stepVO.setResponseList(ResponseDTOImpl.buildListVO(step.getResponse()));

            return stepVO;
        }
        return null;
    }
}
