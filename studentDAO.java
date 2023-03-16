package dao;

import connection.MyConnection;
import model.Students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {

    public List<Students> getAll(){
        List<Students> studentList = new ArrayList<>();



        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setYear(rs.getString("year"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGpa(rs.getDouble("gpa"));

                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public List<Students> sort(){
        List<Students> studentList = new ArrayList<>();



        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students order by full_name";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setYear(rs.getString("year"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGpa(rs.getDouble("gpa"));

                studentList.add(s);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public Students getById(String id) {
        Students s= null;
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students WHERE id = " + id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                s = new Students();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setYear(rs.getString("year"));
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setGpa(rs.getDouble("gpa"));

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Students Search(String s) {
        Students search= null;
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students WHERE id LIKE '"+s+"";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                search = new Students();
                search.setId(rs.getString("id"));
                search.setFull_name(rs.getString("full_name"));
                search.setGender(rs.getInt("gender"));
                search.setYear(rs.getString("year"));
                search.setAddress(rs.getString("address"));
                search.setEmail(rs.getString("email"));
                search.setPhone(rs.getString("phone"));
                search.setGpa(rs.getDouble("gpa"));

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return search;
    }
    public void insert(Students s) {

        if (getById(s.getId()) != null) {
            System.out.println("ID này đã tồn tại");
        } else {
            final String sql = String.format("INSERT INTO students VALUES ('%s','%s',%d,'%s','%s','%s','%s','%f')",
                    s.getId(), s.getFull_name(), s.getGender(), s.getYear(), s.getAddress(), s.getEmail(), s.getPhone(), s.getGpa()
            );

            try {
                Connection conn = MyConnection.getConnection();
                Statement stmt = conn.createStatement();

                int rs = stmt.executeUpdate(sql);
                if (rs == 0) {
                    System.out.println("Thêm thất bại!");
                }
                stmt.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void delete(String id) {

        if (getById(id)==null){
            System.out.println("Không tồn tại id này!");
        }
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM `students` WHERE `id` = %s",id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(Students s,String id) {
        if (getById(id)==null){
            System.out.println("Không tồn tại id này!");
        }

        final String sql = String.format("UPDATE students SET `full_name`='%s',`gender`=%d,`year`='%s',`address`='%s',`email`='%s',`phone`='%s',`gpa`='%f' WHERE `id`='%s'",
                s.getFull_name(), s.getGender(), s.getYear(), s.getAddress(), s.getEmail(), s.getPhone(), s.getGpa(), id
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
