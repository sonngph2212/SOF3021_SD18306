package fpt.com.assignment.service;

import fpt.com.assignment.dto.AppParamDto;
import fpt.com.assignment.repository.AppParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    private AppParamRepository repository;

    public AppParamDto getAppParam(String param, String value) {
        return repository.getAppParam(param, value);
    }
}
