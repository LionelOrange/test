package org.smart.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart.chapter2.service.CustomerService;
import org.smart.chapter2.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chencheng on 2017-06-28.
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService=new CustomerService();
    }

    @Before
    public void init(){
        
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomer() throws Exception {
        Customer customer = customerService.getCustomer(2);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String,Object> fieldMap=new HashMap<>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","1351233421");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        Map<String,Object> fileMap=new HashMap<>();
        fileMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(1, fileMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        boolean result = customerService.deleteCustomer(1);
        Assert.assertTrue(result);
    }
}
