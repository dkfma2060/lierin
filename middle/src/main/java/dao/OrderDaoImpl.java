package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Order;
import dto.Seller;
import mapper.OrderMapper;

public class OrderDaoImpl{
	private SqlSessionFactory sqlSessionFactory;

	public void setDataSource(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	// seller에서 customer가 주문한 상품을 가져오는 메소드(주문번호 group by 적용 x=디테일)
	public List<Order> SOrderList(int sseq, int oseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOrderList(sseq, oseq);
		} finally {
			sqlSession.close();
		}
	}

	// 주문내역에 관한 총합계
	public int SOrderListCount(@Param("sseq") int sseq, @Param("oseq") int oseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOrderListCount(sseq, oseq);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 총 합산 금액을 가져오는 메소드
	public List<Integer> STotalPrice(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).STotalPrice(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 상품 내역을 가져오는 메소드 (주문번호 group by)
	public List<Order> SOseqOrderList(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqOrderList(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 총 갯수를 가져오는 메소드 (주문번호 group by)
	public List<Integer> SOseqCountList(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqCountList(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 총 합산 금액을 가져오는 메소드 (주문상태 적용)
	public List<Integer> STotalPrice2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).STotalPrice2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 상품 내역을 가져오는 메소드 (주문번호 group by) (주문상태 적용)
	public List<Order> SOseqOrderList2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqOrderList2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

	// 주문 번호별 총 갯수를 가져오는 메소드 (주문번호 group by) (주문상태 적용)
	public List<Integer> SOseqCountList2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqCountList2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

}
