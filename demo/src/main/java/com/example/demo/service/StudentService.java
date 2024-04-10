package com.example.demo.service;
import com.example.demo.message.Student;
import org.springframework.stereotype.Service;
import com.mybatisflex.core.service.IService;
import java.util.List;

@Service
public interface StudentService {
    List<Student> add(String userName,String passWord);
    List<Student> update(String username);
    List<Student> delete(String username);
    List<Student> contextLoads(String username);
    List<Student> listAll();
}
