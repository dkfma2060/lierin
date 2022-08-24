package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.Customer;

//��� Ż�� 
public interface CustomerMapper {
	@Select("select * from customer where email=#{email}")
	public Customer getLoginInfo(@Param("email")String email) throws Exception;
	
	@Select("select * from customer where email=#{email} and pw=#{pw}")
	public Customer getMember(@Param("email")String email, @Param("pw")String pw) throws Exception;
	
	@Select("select * from customer")
	public List<Customer> getCustomerAll()throws Exception;
	
	@Delete("delete from customer where email=#{email}")
	public void getDelete(Customer customer)throws Exception;
	
	@Select("select * from customer where status=1")
	public List<Customer> getLeave()throws Exception;
	
	@Select("select * from customer where email=#{email}")
	public Customer getSelect(@Param("email") String email) throws Exception;

	@Update("update customer set name=#{name},email=#{email},pw=#{pw},phone=#{phone},grade=#{grade},point=#{point} where email=#{email}")
	public int getUpdate(Customer customer) throws Exception;
	
}