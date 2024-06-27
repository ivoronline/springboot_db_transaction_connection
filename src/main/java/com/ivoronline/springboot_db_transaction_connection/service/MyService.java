package com.ivoronline.springboot_db_transaction_connection.service;

import com.ivoronline.springboot_db_transaction_connection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private MyRepository repository;
  @Autowired private DataSource   dataSource;

  //=========================================================================================================
  // INSERT RECORDS
  //=========================================================================================================
  public void insertRecords() throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection(); //Exception: Connection was Closed

    //TRANSACTION
    try {

      //START TRANSACTION
      connection.setAutoCommit(false);

      //EXECUTE SQL STATEMENTS (Inserts both Records or none)
      for (int i = 1; i <= 2; i++) {
        if(i==2) { throw new Exception("Exception"); }
        repository.insert("Person " + i, 10 * i);
      }

      //COMMIT TRANSACTION
      connection.commit();

    } catch (Exception e) {
      //ROLLBACK TRANSACTION
      connection.rollback();
    }
    finally {
      connection.close();
    }

  }

}
