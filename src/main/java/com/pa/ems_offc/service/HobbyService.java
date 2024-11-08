package com.pa.ems_offc.service;

import com.pa.ems_offc.dto.DepartmentDto;
import com.pa.ems_offc.dto.HobbyDto;

import java.util.List;

public interface HobbyService {

    HobbyDto createHobby(HobbyDto hobbyDto);

    HobbyDto getHobbyById(Long hobbyId);

    List<HobbyDto> getAllHobbies();

    HobbyDto updateHobby(Long hobbyId, HobbyDto updatedHobby);

    void deleteHobby(Long hobbyId);

}


