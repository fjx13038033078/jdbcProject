import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/testdata";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";
    public static void update() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            statement = connection.createStatement();
            //String sql = "insert into student values(1,'zs',23,'sx')";
            //String sql = "update student set STUNAME = 'ls'where stuno = 1";
            String sql = "delete from student where stuno=1";
            //执行sql
            int count = statement.executeUpdate(sql);
            //处理结果
            if (count > 0){
                System.out.println("操作成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();

        }

    }

    public static void select() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            statement = connection.createStatement();

            //String sql = "select stuno , stuname from student";
            //模糊查询
            String name = "x";
            String sql = "select * from student where stuname like '%"+name+"%'";
            //执行sql
            ResultSet resultSet = statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                int stuno = resultSet.getInt("stuno");
                String stuname = resultSet.getString("stuname");
//                int stuno = resultSet.getInt(1);
//                String stuname = resultSet.getString(2);
                System.out.println(stuno+stuname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        select();
    }
}
