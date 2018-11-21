/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prad.webapp.entity.daoimpl;

import com.prad.webapp.entity.Course;
import com.prad.webapp.entity.dao.CourseDAO;
import com.prad.webapp.entity.dbutil.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conne
 */
public class CourseDAOImpl implements CourseDAO {

    private DbConnection db = new DbConnection();

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        List<Course> courseList = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        db.connect();
        db.initStatement(sql);
        ResultSet rs = db.query();
        while (rs.next()) {
            Course c = new Course();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setStatus(rs.getBoolean("status"));
            courseList.add(c);
        }
        db.close();
        return courseList;
    }

    @Override
    public int insert(Course course) throws ClassNotFoundException, SQLException {

        String sql = "INSERT into courses(name,fees,status)"
                + "VALUES(?,?,?)";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        int result = db.Update();
        db.close();
        return result;
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        Course c = null;

        String sql = "SELECT * FROM courses where id= ?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.query();
        if (rs.next()) {
            c = new Course();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setStatus(rs.getBoolean("status"));
        }
        db.close();
        return c;
    }

    @Override
    public int update(Course course) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE courses set name=?, fees=?,status=? "
                + "WHERE id= ?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setInt(2, course.getFees());
        stmt.setBoolean(3, course.isStatus());
        stmt.setInt(4, course.getId());
        int result = db.Update();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {

        String sql = "DELETE from courses WHERE id=?";
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);

        stmt.setInt(1, id);
        int result = db.Update();
        db.close();
        return result;

    }

}
