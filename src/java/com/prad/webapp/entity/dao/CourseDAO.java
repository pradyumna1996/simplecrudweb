/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prad.webapp.entity.dao;

import com.prad.webapp.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author conne
 */
public interface CourseDAO {
    List<Course> getAll() throws ClassNotFoundException,SQLException;
    Course  getById(int id) throws ClassNotFoundException,SQLException;
    int insert(Course course) throws ClassNotFoundException,SQLException;
    int update(Course course) throws ClassNotFoundException,SQLException;
    int delete(int id) throws ClassNotFoundException,SQLException;

    
}
