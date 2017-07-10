package testDB;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;



public class testClass {

    static Object[][] databaseInfo;

    static java.lang.Object[] columns = {"Year","PlayerID","Name","TTRC","Team","Salary","CPR","POS"};

    static ResultSet rows;

    static ResultSetMetaData metaData;

    static DefaultTableModel defaultTableModel = new DefaultTableModel(databaseInfo,columns ){
        public Class getColumnClass(int column){
            Class returnValue;

            if ((column >= 0) && (column < getColumnCount())){
                returnValue = getValueAt(0,column).getClass();
            } else {
                returnValue = Object.class;
            }
            return returnValue;
        }
    };


    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lahman591?autoReconnect=true&useSSL=false", "root","Lafamilia");

            Statement sqlState = conn.createStatement();

            String selectStuff = "select b.yearID, b.playerID, " +

                    "CONCAT(m.nameFirst, ' ', m.nameLast) AS NAME, " +

                    "((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " +

                    "b.teamID AS Team, 0 AS Salary, " +

                    "0 AS CPR, f.POS AS POS " +

                    "FROM Batting b, Master m, Fielding f, TOTBYR as t " +

                    "WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +

                    "AND t.yearID = 2011 AND b.yearID = t.yearID " +

                    "AND b.AB > 100 AND f.playerID = b.playerID " +

                    "GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";


            rows = sqlState.executeQuery(selectStuff);

            java.lang.Object[] temRow;

            while (rows.next()){
                temRow = new java.lang.Object[]{rows.getInt(1),rows.getString(2),
                        rows.getString(3),rows.getDouble(4),rows.getString(5),
                        rows.getInt(6), rows.getDouble(7),rows.getString(8)};
                defaultTableModel.addRow(temRow);
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        JTable table = new JTable(defaultTableModel);
        table.setRowHeight(table.getRowHeight() + 10);
        table.setFont(new Font("Serif",Font.PLAIN, 20));
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);
        TableColumn col2 = table.getColumnModel().getColumn(1);
        col1.setPreferredWidth(190);

        TableColumn tc = table.getColumn("Team");
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        tc = table.getColumn("POS");
        centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800,500);
        frame.setVisible(true);
    }

}

class CenterTableCellRenderer extends DefaultTableCellRenderer {
    public CenterTableCellRenderer(){
        setHorizontalAlignment(JLabel.CENTER);
    }
}

