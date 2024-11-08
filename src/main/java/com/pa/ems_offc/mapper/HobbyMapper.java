package com.pa.ems_offc.mapper;
import com.pa.ems_offc.dto.HobbyDto;
import com.pa.ems_offc.model.Hobby;

public class HobbyMapper {

    //Convertir la Entidad JPA Hobby en un Hobby DTO
    public static HobbyDto mapToHobbyDto(Hobby hobby) {
        return new HobbyDto(
                hobby.getId(),
                hobby.getHobbyName(),
                hobby.getHobbyDescription()
        );
    }

    //Convertir el Hobbby DTO en una Entidad JPA Hobby
    public static Hobby mapToHobby(HobbyDto hobbyDto) {
        Hobby hobby = new Hobby();
        hobby.setId(hobbyDto.getId());
        hobby.setHobbyName(hobbyDto.getHobbyName());
        hobby.setHobbyDescription(hobbyDto.getHobbyDescription());
        return hobby;
    }

}
