package com.ivoronline.springboot_db_transaction_connection.controller;

import com.ivoronline.springboot_db_transaction_connection.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService personService;

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/insert")
  public String insert() throws SQLException {
    personService.insert();
    return "Records Inserted";
  }

}
