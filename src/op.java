import java.io.*;
import java.sql.*;

public class op {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase" ;
    private static final String password = "@#aditya2006";
    private static final String username = "root";


    public static void main(String args[]) {

        // image insert

//        String image_path = "C:\\Users\\admin\\Pictures\\my\\20230919_115042.jpg";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (ClassNotFoundException e) {
//            System.out.println("error at driver.");
//        }
//        String query = "insert into image_table(image_data) values (?)";
//
//        try {
//            Connection cn = DriverManager.getConnection(url,username,password);
//            FileInputStream f = new FileInputStream(image_path);
//            byte imageStore[] = new byte[f.available()];
//            f.read(imageStore);
//            PreparedStatement ps = cn.prepareStatement(query);
//            ps.setBytes(1,imageStore);
//            int afr = ps.executeUpdate();
//            if(afr > 0) {
//                System.out.println("image insert succesfully");
//            }else {
//                System.out.println("image insert unsuccesfully");
//            }
//
//        }catch (SQLException | IOException e) {
//            System.out.println("error at get connection or image loading.");
//        }



        // image retrive


        String folder_path = "C:\\Users\\admin\\Pictures\\image_DB\\";
        String query = "select image_data from image_table where image_id = ?;";

        try {
            Connection cn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1,2);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                byte image_data[] = rs.getBytes("image_data");
                String image_path_con = folder_path + "Aditya.jpg";
                OutputStream op = new FileOutputStream(image_path_con);
                op.write(image_data);
            }else {
                System.out.println("for this id no image found.");
            }
        }catch (SQLException | IOException e ) {
            System.out.println("error at get connection.");
        }

    }
}
