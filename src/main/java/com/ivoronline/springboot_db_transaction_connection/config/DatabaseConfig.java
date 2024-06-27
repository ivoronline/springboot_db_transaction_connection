package com.ivoronline.springboot_db_transaction_connection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

  //PROPERTIES
  @Autowired private DataSource dataSource;

  //=========================================================================================================
  // JDBC TEMPLATE
  //=========================================================================================================
  @Bean
  public JdbcTemplate jdbcTemplate() throws SQLException {
    return new JdbcTemplate(new SingleConnectionDataSource(dataSource.getConnection(), true));
  }

}
