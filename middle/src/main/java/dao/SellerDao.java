package dao;

import java.util.List;

import dto.Seller;

public interface SellerDao {
	Seller SelectCByEmail(String email) throws Exception;
	Seller SelectCByEamilAndPw(String email, String pw) throws Exception;
	void joinSeller(Seller seller) throws Exception;
	List<Seller> selectList() throws Exception;
	void delete(Seller seller)throws Exception;
	List<Seller> leaveList()throws Exception;
}
