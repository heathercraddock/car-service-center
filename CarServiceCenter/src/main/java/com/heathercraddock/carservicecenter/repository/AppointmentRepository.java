package com.heathercraddock.carservicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathercraddock.carservicecenter.domain.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	
	/*
	
	public interface StudentDAO extends JpaRepository<StudentEntity, Integer> {
    public findAllOrderByIdAsc();   // I want to use some thing like this
}

	
	
	
	import org.springframework.data.domain.Sort;



@Repository
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
} 
	 */
	
}
