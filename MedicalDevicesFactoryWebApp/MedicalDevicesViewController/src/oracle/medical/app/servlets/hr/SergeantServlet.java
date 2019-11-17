package oracle.medical.app.servlets.hr;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;

public class SergeantServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        OutputStream os = response.getOutputStream();

        String id = request.getParameter("id");

        Connection conn = null;
        try {

            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/AppConnectionDS");
            conn = ds.getConnection();
            System.out.println("DB Connection ok");

            String sql = "SELECT SERGEANT_ID, IMAGE " + " FROM SERGEANTS" + " WHERE SERGEANT_ID =?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("IMAGE");

                BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream());
                int b;
                byte[] buffer = new byte[10240];
                while ((b = in.read(buffer, 0, 10240)) != -1) {
                    os.write(buffer, 0, b);
                }
                os.close();
            } else {

                ServletContext sc = getServletContext();
                String filename = sc.getRealPath("/images/unknown.png");
                String mimeType = sc.getMimeType(filename);
                response.setContentType(mimeType);
                File file = new File(filename);
                response.setContentLength((int) file.length());
                FileInputStream in = new FileInputStream(file);
                OutputStream out = response.getOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = in.read(buf)) >= 0) {
                    out.write(buf, 0, count);
                }
                in.close();
                out.close();
            }

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
            ServletContext sc = getServletContext();
            String filename = "";
            filename = sc.getRealPath("/images/unknown.png");
            String mimeType = sc.getMimeType(filename);
            response.setContentType(mimeType);
            File file = new File(filename);
            response.setContentLength((int) file.length());
            FileInputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = in.read(buf)) >= 0) {
                out.write(buf, 0, count);
            }
            in.close();
            out.close();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLException error");
            }
        }


    }
}
