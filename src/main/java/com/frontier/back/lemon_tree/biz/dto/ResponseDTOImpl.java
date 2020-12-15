package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.ResponseVO;
import com.frontier.back.lemon_tree.data.entity.Response;
import com.frontier.back.lemon_tree.data.entity.Step;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTOImpl {
    public static ResponseVO buildVO(Response response){
        if (response != null){
            ResponseVO responseVO = new ResponseVO();
            responseVO.setId(response.getId());
            responseVO.setDescription(response.getDescription());
            responseVO.setIdNextStep(response.getIdNextStep());
            responseVO.setIdOriginalStep(response.getIdOriginalStep());
            responseVO.setResponse_type(response.getResponseType());

            return responseVO;
        }
        return null;
    }

    public static List<ResponseVO> buildListVO(List<Response> responseList){
        if (responseList != null){
            List<ResponseVO> list = new ArrayList<>();
            responseList.forEach(response -> list.add(buildVO(response)));

            return list;
        }
        return null;
    }
}
