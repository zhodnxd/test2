package com.example.demo.service.Impl;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.message.Student;
import com.example.demo.message.table.StudentTableDef;
import com.example.demo.service.StudentService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> listAll(){
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> add(String userName,String passWord){
        Student student = new Student();
        student.setUserName(userName);
        student.setPassword(passWord);
        Student student2 = UpdateWrapper.of(student)
                .setRaw(Student::getCreated_time, "now()")
                .toEntity();
        studentMapper.insert(student2);
        return studentMapper.selectAll();
    }
    @Override
    public List<Student> update(String userName){
        QueryWrapper queryWrapper=QueryWrapper.create()
                .select(StudentTableDef.STUDENT.ALL_COLUMNS)
                .from(StudentTableDef.STUDENT)
                .where(StudentTableDef.STUDENT.USER_NAME.eq(userName));
        Student student = UpdateEntity.of(Student.class);
        student.setPassword("123456578");
        studentMapper.updateByQuery(student,queryWrapper);
        return studentMapper.selectAll();
    }
    @Override
    public List<Student> delete(String userName){
        QueryWrapper queryWrapper=QueryWrapper.create()
                .select(StudentTableDef.STUDENT.ALL_COLUMNS)
                .from(StudentTableDef.STUDENT)
                .where(StudentTableDef.STUDENT.USER_NAME.eq(userName));
        studentMapper.deleteByQuery(queryWrapper);
        return studentMapper.selectAll();
    }
    @Override//条件查询
    public List<Student> contextLoads(String userName){
        QueryWrapper queryWrapper=QueryWrapper.create()
                .select(StudentTableDef.STUDENT.ALL_COLUMNS)
                .where(StudentTableDef.STUDENT.USER_NAME.eq(userName));
        return studentMapper.selectListByQuery(queryWrapper);
    }

}
