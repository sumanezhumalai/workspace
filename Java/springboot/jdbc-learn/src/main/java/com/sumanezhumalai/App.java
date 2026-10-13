package com.sumanezhumalai;

import com.sumanezhumalai.service.PreparedStatementService;

public class App {
    public static void main(String[] args) {
        // // Statement practice
        // StatementService stmtDb = new StatementService();
        // String retrievalQuery = "SELECT * FROM person";
        // stmtDb.selectAll(retrievalQuery);
        // System.out.println("\nRow's Inserted : "
        // + stmtDb.executeUpdate("INSERT INTO person (name) VALUES ('Ramulan')"));
        // System.out.println(stmtDb.executeUpdate("UPDATE person set name='Suman '
        // WHERE id = 1") > 0
        // ? "Updated Successfuly" : "Update Failed");
        // System.out.println(stmtDb.executeUpdate("DELETE FROM person WHERE id = 8") >
        // 0
        // ? "Deleted Successfuly" : "Delete Failed");
        // System.out.println();
        // stmtDb.selectAll(retrievalQuery);

        // PreparedStatement practice
        PreparedStatementService db = new PreparedStatementService();

        db.selectAll();

        System.out.println("\nRow's Inserted : " + db.insert("Ramulan"));

        System.out.println(db.updateName(1, "Suman ") > 0 ? "Updated Successfuly" : "Update Failed");

        System.out.println(db.delete(8) > 0 ? "Deleted Successfuly" : "Delete Failed");

        System.out.println();
        db.selectAll();

        System.out.println();
        db.selectById(1);
    }
}
