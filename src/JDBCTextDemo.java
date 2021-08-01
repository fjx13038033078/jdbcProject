import java.io.*;
import java.sql.*;

public class JDBCTextDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/testdata";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";
    //通过jdbc存储大文本数据（小说）
    //设置clob类型：setCharacterStream()
    public static void update() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接

            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            String sql = "insert into mynovel values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            File file = new File("D:\\Java学习\\Java-web学习\\jdbc\\笑傲江湖.txt");
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in,"GBK");
            preparedStatement.setCharacterStream(2,reader,file.length());

            //执行sql
            int count = preparedStatement.executeUpdate();
            //处理结果
            if (count > 0){
                System.out.println("操作成功");
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();

        }

    }

    public static void read() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //导入驱动
            Class.forName("com.mysql.jdbc.Driver");
            //与数据库建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);

            String sql = "select novel from mynovel where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);

            //String sql = "select stuno , stuname from student";
            //模糊查询

            //执行sql
            resultSet = preparedStatement.executeQuery();//无参数
            //处理结果
            if (resultSet.next()){
                Reader re = resultSet.getCharacterStream("novel");
                Writer writer = new FileWriter("src/笑傲江湖.txt");
                char[] chs = new char[100];
                int len = -1;
                while ((len = re.read( chs ))!=-1){
                    writer.write(chs,0,len);
                }
                writer.close();
                re.close();
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
        //update();
        read();
    }
}
