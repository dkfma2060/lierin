package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dto.Seller;


public interface SellerMapper {
	@Select("select * from seller where email=#{email}")
	public Seller getLoginInfo(@Param("email")String email) throws Exception;
	
	@Select("select * from seller where email=#{email} and pw=#{pw}")
	public Seller getMember(@Param("email")String email, @Param("pw")String pw) throws Exception;

	@Insert("insert into seller (name,email,pw,phone) vlaues(${name},${email},${pw},${phone})")
	public void joinSeller(Seller seller) throws Exception;
	
	@Select("select * from seller")
	public List<Seller> getSellerAll()throws Exception;
	
	@Delete("delete from seller where email=#{email}")
	public void getDelete(Seller seller)throws Exception;
	
	@Select("select * from seller where status=1")
	public List<Seller> getLeave()throws Exception;
}
