import java.sql.*;

public class JDBCPreparedStatementDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/testdata";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";
    public static void update() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            /* Statement
            statement = connection.createStatement();
            //String sql = "insert into student values(1,'zs',23,'sx')";
            //String sql = "update student set STUNAME = 'ls'where stuno = 1";
            String sql = "delete from student where stuno=1";
            //执行sql
            int count = statement.executeUpdate(sql);

            */
            //PreparedStatement
            //String sql = "insert into student values(10,'zls',23,'sxx')";
            String sql = "insert into student values(?,?,?,?)";//预编译
            //String sql = "update student set STUNAME = 'ls'where stuno = 1";
            //String sql = "delete from student where stuno=1";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,11);
            preparedStatement.setString(2,"zzs");
            preparedStatement.setInt(3,28);
            preparedStatement.setString(4,"xxx");
            int count = preparedStatement.executeUpdate();
            //处理结果
            if (count > 0){
                System.out.println("操作成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();

        }

    }

    public static void select() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "select * from student where stuname like ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"%x%");

            //String sql = "select stuno , stuname from student";
            //模糊查询

            //执行sql
            resultSet = preparedStatement.executeQuery();//无参数
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
            resultSet.close();
            preparedStatement.close();
            connection.close();

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        select();
    }
}
