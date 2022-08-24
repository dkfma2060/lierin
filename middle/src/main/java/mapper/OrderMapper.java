package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.Customer;
import dto.Order;
import dto.Seller;

public interface OrderMapper {
	@Insert("insert into orders(email, amount) values(#{email}, #{amount})")
	public void insertOrder(@Param("email") String email, @Param("amount") int amount);

	@Insert("insert into order_detail(oseq, pseq, quantity, payment) values(#{oseq}, #{pseq}, #{quantity}, #{payment})")
	public void insertOrderDetail(@Param("oseq") int oseq, @Param("pseq") int pseq, @Param("quantity") int quantity,
			@Param("payment") int payment);

	@Select("select max(oseq) from orders")
	public int selectMaxOseq();

	@Update("update cart set result='y' where pseq=#{pseq} and email=#{email} and quantity=#{quantity}")
	public void updateCartResult(@Param("email") String email, @Param("pseq") int pseq,
			@Param("quantity") int quantity);

	@Update("delete from cart where pseq=#{pseq} and email=#{email} and quantity=#{quantity}")
	public void deleteCart(@Param("email") String email, @Param("pseq") int pseq, @Param("quantity") int quantity);

//	@Select("select * from cart_view where cseq=#{cseq}")
//	public Cart selectCart(@Param("cseq") int cseq);

	@Update("update customer set point=#{point} where email=#{email}")
	public void updateCustomerPoint(@Param("email") String email, @Param("point") int point);

	@Select("select * from customer where email=#{email}")
	public Customer selectCustomer(@Param("email") String email);

	@Select("select point from customer where email=#{email}")
	public int selectPoint(@Param("email") String email);

	@Update("update product set quantity=quantity-#{quantity} where pseq=#{pseq}")
	public void updateQuantity(@Param("pseq") int pseq, @Param("quantity") int quantity);

	@Update("update customer set zip_code=#{zip_code}, address=#{address} where email=#{email}")
	public void updateAddress(@Param("zip_code") String zip_code, @Param("address") String address,
			@Param("email") String email);

	@Select("select * from order_view where email=#{email} and result not in ('3')")
	public List<Order> selectRecentorder(@Param("email") String email);

	// oseq별 (그룹바이 적용 x, 디테일 부분)
	@Select("select * from order_view where sseq=#{sseq} and oseq=#{oseq}")
	public List<Order> SOrderList(@Param("sseq") int sseq, @Param("oseq") int oseq) throws Exception;

	// 주문 번호의 총액(디테일부분 적용)
	@Select("select sum(payment) from order_view where sseq=#{sseq} and oseq=#{oseq} group by oseq")
	public int SOrderListCount(@Param("sseq") int sseq, @Param("oseq") int oseq) throws Exception;

	// oseq 별 합산금액 (그룹바이 적용)
	@Select("select sum(payment) from order_view where sseq=#{sseq} group by oseq")
	public List<Integer> STotalPrice(@Param("sseq") int sseq) throws Exception;

	// oseq 별 count (그룹바이 적용)
	@Select("SELECT count(*) FROM order_view where sseq=#{sseq} group by oseq")
	public List<Integer> SOseqCountList(@Param("sseq") int sseq) throws Exception;

	// oseq 별 리스트 (그룹바이 적용)
	@Select("SELECT * FROM order_view where sseq=#{sseq} group by oseq")
	public List<Order> SOseqOrderList(@Param("sseq") int sseq) throws Exception;

	// oseq 별 합산금액 (그룹바이 적용) ->배송상태에 따라 분류
	@Select("select sum(payment) from order_view where sseq=#{sseq} and result=#{result} group by oseq")
	public List<Integer> STotalPrice2(@Param("sseq") int sseq, @Param("result") int result) throws Exception;

	// oseq 별 합산금액 (그룹바이 적용) ->배송상태에 따라 분류
	@Select("SELECT count(*) FROM order_view where sseq=#{sseq} and result=#{result} group by oseq")
	public List<Integer> SOseqCountList2(@Param("sseq") int sseq, @Param("result") int result) throws Exception;

	// oseq 별 합산금액 (그룹바이 적용) ->배송상태에 따라 분류
	@Select("SELECT * FROM order_view where sseq=#{sseq} and result=#{result} group by oseq")
	public List<Order> SOseqOrderList2(@Param("sseq") int sseq, @Param("result") int result) throws Exception;

	@Update("update order_detail set result=#{result},mod_date=now() where oseq=#{oseq}")
	public void SOrderResultUpdate(@Param("sseq") int sseq, @Param("oseq") int oseq, @Param("result") int result)
			throws Exception;
	
	

}
