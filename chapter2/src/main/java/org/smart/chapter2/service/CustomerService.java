package org.smart.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.chapter2.model.Customer;
import org.smart.chapter2.util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chencheng on 2017-06-28.
 */
public class CustomerService {
    private static final Logger LOGGER=LoggerFactory.getLogger(CustomerService.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jabc driver",e);
        }
    }

    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList() {
        Connection conn=null;
        try {
            List<Customer> customerList=new ArrayList<>();
            String sql="SELECT * FROM customer";
            conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            LOGGER.error("execute sql failure",e);
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error("close connection failure",e);
                }
            }
        }
        return null;
    }

    public Customer getCustomer(long id) {
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return false;
    }

    public boolean deleteCustomer(long id) {
        return false;
    }
}
