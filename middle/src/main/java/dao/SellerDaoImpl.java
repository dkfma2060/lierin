package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Seller;
import mapper.SellerMapper;

public class SellerDaoImpl implements SellerDao {
	private SqlSessionFactory sqlSessionFactory;

	public void setDataSource(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Seller SelectCByEmail(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(SellerMapper.class).getLoginInfo(email);
			// return mapper.getLoginInfo(email);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Seller SelectCByEamilAndPw(String email, String pw) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(SellerMapper.class).getMember(email,pw);
		}finally{
			// TODO: handle exception
			sqlSession.close();
		}
	}
	
	@Override
	public void joinSeller(Seller seller) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			sqlSession.getMapper(SellerMapper.class).joinSeller(seller);
		}finally{
			// TODO: handle exception
			sqlSession.close();
		}
		
	}

	@Override
	public List<Seller> selectList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(SellerMapper.class).getSellerAll();
		}finally{
			sqlSession.close();
		}
	}

	@Override
	public void delete(Seller seller) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.getMapper(SellerMapper.class).getDelete(seller);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
		
	}
	
	@Override
	public List<Seller> leaveList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(SellerMapper.class).getLeave();	
		}finally {
			sqlSession.close();
		}
	}

}
