package com.edu.miu.SchoolService.service;

import com.edu.miu.SchoolService.domain.School;
import com.edu.miu.SchoolService.domain.Schools;
import com.edu.miu.SchoolService.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public void addSchool(School school){
        schoolRepository.save(school);
    }

    public School getSchool(String schoolId){
        return schoolRepository.findById(schoolId).orElse(null);
    }

    public Schools getAllSchools(){
        Schools schools = new Schools();
        List<School> schoolList = schoolRepository.findAll();
        schools.setSchools(schoolList);
        return schools;

    }

    public boolean updateSchool( String schoolId, School school) {
        Optional<School> oldTeacher = schoolRepository.findById(schoolId);
        if (oldTeacher.isEmpty()) {
            return false;
        }
        school.setSchoolId(schoolId);
        School updatedSchool = schoolRepository.save(school);
        return true;
    }

    public boolean deleteSchool(String schoolId){
        try {
            schoolRepository.deleteById(schoolId);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
