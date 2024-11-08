package com.pa.ems_offc.service.impl;


import com.pa.ems_offc.dto.HobbyDto;
import com.pa.ems_offc.exception.ResourceNotFoundException;
import com.pa.ems_offc.mapper.HobbyMapper;
import com.pa.ems_offc.model.Hobby;
import com.pa.ems_offc.repository.HobbyRepository;
import com.pa.ems_offc.service.HobbyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HobbyServiceImpl implements HobbyService {

    private HobbyRepository hobbyRepository;

    @Override
    public HobbyDto createHobby(HobbyDto hobbyDto) {
        Hobby hobby = HobbyMapper.mapToHobby(hobbyDto);
        Hobby savedHobby = hobbyRepository.save(hobby);
        return HobbyMapper.mapToHobbyDto(savedHobby);
    }

    @Override
    public HobbyDto getHobbyById(Long hobbyId) {
        Hobby hobby = hobbyRepository.findById(hobbyId).orElseThrow(
                    () -> new ResourceNotFoundException("Hobby is not exists with a given id: " + hobbyId)
        );
        return HobbyMapper.mapToHobbyDto(hobby);
    }

    @Override
    public List<HobbyDto> getAllHobbies() {
        List<Hobby> hobbies = hobbyRepository.findAll();
        return hobbies.stream().map(HobbyMapper::mapToHobbyDto)
                .collect(Collectors.toList());
    }

    @Override
    public HobbyDto updateHobby(Long hobbyId, HobbyDto updatedHobby) {

        Hobby hobbies = hobbyRepository.findById(hobbyId).orElseThrow(
                () -> new ResourceNotFoundException("Hobby is not exists with a given id:"+ hobbyId)
        );

        hobbies.setHobbyName(updatedHobby.getHobbyName());
        hobbies.setHobbyDescription(updatedHobby.getHobbyDescription());

        Hobby savedHobby = hobbyRepository.save(hobbies);

        return HobbyMapper.mapToHobbyDto(savedHobby);
    }

    @Override
    public void deleteHobby(Long hobbyId) {
        hobbyRepository.findById(hobbyId).orElseThrow(
                () -> new ResourceNotFoundException("Hobby is not exists with a given id: " + hobbyId)
        );

        hobbyRepository.deleteById(hobbyId);
    }

}

