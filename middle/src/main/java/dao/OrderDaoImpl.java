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
	
	// seller���� customer�� �ֹ��� ��ǰ�� �������� �޼ҵ�(�ֹ���ȣ group by ���� x=������)
	public List<Order> SOrderList(int sseq, int oseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOrderList(sseq, oseq);
		} finally {
			sqlSession.close();
		}
	}

	// �ֹ������� ���� ���հ�
	public int SOrderListCount(@Param("sseq") int sseq, @Param("oseq") int oseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOrderListCount(sseq, oseq);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� �� �ջ� �ݾ��� �������� �޼ҵ�
	public List<Integer> STotalPrice(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).STotalPrice(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� ��ǰ ������ �������� �޼ҵ� (�ֹ���ȣ group by)
	public List<Order> SOseqOrderList(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqOrderList(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� �� ������ �������� �޼ҵ� (�ֹ���ȣ group by)
	public List<Integer> SOseqCountList(int sseq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqCountList(sseq);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� �� �ջ� �ݾ��� �������� �޼ҵ� (�ֹ����� ����)
	public List<Integer> STotalPrice2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).STotalPrice2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� ��ǰ ������ �������� �޼ҵ� (�ֹ���ȣ group by) (�ֹ����� ����)
	public List<Order> SOseqOrderList2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqOrderList2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

	// �ֹ� ��ȣ�� �� ������ �������� �޼ҵ� (�ֹ���ȣ group by) (�ֹ����� ����)
	public List<Integer> SOseqCountList2(int sseq, int result) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(OrderMapper.class).SOseqCountList2(sseq, result);
		} finally {
			sqlSession.close();
		}

	}

}
