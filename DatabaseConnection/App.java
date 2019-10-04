/*
 * Name:
 *      App.java
 * Version:
 *      1.0
 * Revisions:
 *      None
 */
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.sql.*;
import java.util.Scanner;

/**
 * Class used for execution of statements
 */
public class App {
    private final String url = "jdbc:postgresql://reddwarf.cs.rit.edu/";
    private final String user = "csci605";
    private final String password = "sometables";
    Statement stmt = null;
    Connection conn = null;
    ResultSet rs = null;

    public Connection connect()  {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT to_parse FROM sites");

            if (rs.next()) {
                System.out.println(rs.getString(1));
                URL aURL = new URL(rs.getString(1));
                URLConnection yc = aURL.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(aURL.openStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains("hidden")) {
                        System.out.println(inputLine);
                        String s1 =
                                inputLine.substring(inputLine.indexOf("=")+1);
                        s1.trim();
                        String s2= s1.substring(0,s1.indexOf("-"));
                        s2.trim();
                        System.out.println(s2);
                        ReadableByteChannel readChannel =
                                Channels.newChannel(new URL(s2).openStream());
                        System.out.println("Please enter the path to the " +
                                "folder where the current file is saved");
                        Scanner inp = new Scanner(System.in);
                        String s = inp.nextLine();
                        FileOutputStream fileOS = new FileOutputStream(s+
                                "\\Ranges.java");
                        FileChannel writeChannel = fileOS.getChannel();
                        writeChannel
                                .transferFrom(readChannel, 0, Long.MAX_VALUE);
                    }
                }
                in.close();
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }
    public static void main(String[] args) throws SQLException {
        App app = new App();
        app.connect();
        try {
            runProcess("javac Ranges.java");
            System.out.println("**********");
            runProcess("java Ranges");
        } catch (Exception e) {
            e.printStackTrace();
        }

        app.disconnect();
    }
}
