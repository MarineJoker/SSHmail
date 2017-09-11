package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.dialect.ProgressDialect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.account;
import com.domain.employee;
import com.domain.product;
import com.domain.sorder;
import com.domain.users;
import com.liu.AccountService;
import com.liu.AccountServiceimpl;
import com.liu.CategoryService;
import com.liu.CategoryServiceimpl;
import com.liu.ProductService;
import com.liu.SorderService;
import com.liu.UsersService;
import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.launcher.resources.launcher;

import java.util.Date;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")  
public class test {  
      
    @Resource   
    private CategoryService categorService;
    @Resource 
    private AccountService accountService;
    @Resource
    private ProductService productService;
    @Resource 
    private UsersService usersService;
    @Resource 
    private SorderService sorderService;
    @Test //测试Spring IOC的开发环境  
    public void hibernateandspring(){
//    	account account1=new account();
//    	account1.setName("113");
//    	account1.setLogin("aaa");
//    	account1.setPass("1");
//    	account1.setId(1);
//    	account1.setId(2);
//    	employee employee1=new employee();
//    	employee1.setType("aa");
//    	employee1.setHot("666");
//    	employee1.setEid(2);
//    	employee employee2=new employee();
//    	employee2.setAccount1(account1);
//    	employee2.setEid(3);
//    	employee2.setHot("true");
//    	employee2.setType("bbb");
//    	employee2.setAccount1(account1);
//    	employee2.setAccount1(account1);
//    	accountService.save(account1);
//    	categorService.save(employee2);
//    	employee employee1=new employee();
//    	Date date=new Date();
//    	employee1.setEid(2);
//    	product p=new product(employee1, "aa", 12.5, "bb", "cc", "dd", date, true, true);
//    	productService.save(p);
//    	account account1=new account();
//    	account1.setId(1);
//    	employee employee1=new employee(account1, "qaq", "wsw");
////    	employee1.setEid(2);
//    	categorService.update(employee1);
    	sorder s=new sorder();
    	s.setName("11");
    	sorderService.save(s);
//    	System.out.println(productService.queryJoinCategory("aa", 1, 1).get(0).getDate());
//    	List<account> list=accountService.query();
//    	System.out.println(list);
    	//System.out.println(list.get(0).getLogin());
//    	Iterator s=list.iterator();
//    	while(s.hasNext())
//    	{
//    		employee employe=new employee();
//    		employe=(employee) s.next();
//    		
//    		System.out.println(employe.getType());
//    		System.out.println(employe.getHot());
//    		System.err.println(employe.ge);
//    	}
//    	Long sLong=categorService.getCount("bb");
//    	System.out.println("Long:"+sLong);
    	
   
    }
}
