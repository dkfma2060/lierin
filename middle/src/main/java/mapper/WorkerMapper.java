package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dto.Sales;
import dto.SellerSales;
import dto.Wnotice;
import dto.Worker;

public interface WorkerMapper {
	@Select("select * from worker where id=#{id}")
	public Worker getLoginInfo(@Param("id") String id) throws Exception;

	@Select("select * from worker where id=#{id} and pw=#{pw}")
	public Worker getWorker(@Param("id") String id, @Param("pw") String pw) throws Exception;

	@Select("select * from worker")
	public List<Worker> getWorkerAll() throws Exception;

	@Insert("insert into worker(name, id, pw, email, phone) value(#{name}, #{id}, #{pw}, #{email}, #{phone})")
	public int getAdd(Worker worker) throws Exception;

	@Select("select id from worker where id=#{id}")
	public Worker getIdCheck(@Param("id") String id) throws Exception;

	@Select("select * from worker where id=#{id}")
	public Worker getSelect(@Param("id") String id) throws Exception;

	@Update("update worker set pw=#{pw}, phone=#{phone} where id=#{id}")
	public int getUpdate(Worker worker) throws Exception;

	// �Խ��� ���
	@Insert("insert into wnotice(name,type,title,detail) value(#{name},#{type},#{title},#{detail})")
	public int getNoticeAdd(Wnotice notice) throws Exception;

	// �Խ��� �������� list
	@Select("select * from wnotice where type=0")
	public List<Wnotice> getNoticeAll() throws Exception;

	// �Խ��� QnA list
	@Select("select * from wnotice where type=1")
	public List<Wnotice> getQnaAll() throws Exception;

	// �Խù� delete
	@Delete("delete from wnotice where wseq=#{wseq}")
	public void getBoardDelete(@Param("wseq") int wseq) throws Exception;

	// �Խù� update
	@Update("update wnotice set title=#{title}, detail=#{detail} where wseq=#{wseq}")
	public int getBoardUpdate(Wnotice notice) throws Exception;

	// �Խù� select
	@Select("select * from wnotice where wseq=#{wseq}")
	public Wnotice getBoardAll(@Param("wseq") int wseq) throws Exception;

	// ����� ���� ���� ����Ʈ
	@Select("select order_view.name,order_view.email,order_view.payment, customer.grade,customer.reg_date from order_view left join customer on order_view.email = customer.email group by name")
	public List<Sales> getCustomerSale() throws Exception;

	// ����ں� �� ����
	@Select("select sum(payment) from order_view group by name")
	public List<Integer> getSales() throws Exception;

	// ����� ��¥�� �� ����
	@Select("SELECT DATE_FORMAT(reg_date, '%Y%m%d') AS date, sum(payment) AS cnt FROM order_view GROUP BY DATE_FORMAT(reg_date, '%Y%m%d') ORDER BY date DESC")
	public List<Integer> getDateSales() throws Exception;

	// �ֹ����� ���� ��ǰ ranking top 8 �޾ƿ���
	// @Select("select * from (select pseq,pname,payment,sum(quantity),dense_rank()
	// over (order by sum(quantity) desc)as ranking from order_view GROUP BY pseq)
	// ranked where ranked.ranking<8")
	@Select("select pseq, count(pseq) from order_view group by pseq order by count(pseq) desc limit 8")
	public List<Integer> getRank() throws Exception;

	// ranking top ��ǰ best ���� y�� ����
	@Update("update product set best='y'where pseq=#{pseq}")
	public int getBest(@Param("pseq") int pseq) throws Exception;

	// best_p_view List �޾ƿ���
	@Select("select * from best_p_view")
	public List<Integer> getBestList() throws Exception;

	// ranking top ��ǰ�� �ƴѰ��� best ���� n���� ����
	@Update("update product set best='n'where pseq=#{pseq}")
	public int getDeleteBest(@Param("pseq") int pseq) throws Exception;

	// ���ƿ䰡 ���� ��ǰ ranking top 6 list �޾ƿ���
	// @Select("select * from (select pseq,count(*),dense_rank() over (order by
	// count(*) desc)as ranking from like_view GROUP BY pseq) ranked where
	// ranked.ranking<6")
	@Select("select pseq, count(pseq) from like_view group by pseq order by count(pseq) desc limit 6;")
	public List<Integer> getLikeRank() throws Exception;

	// ranking top ��ǰ recommend ���� y�� ����
	@Update("update product set recommend='y'where pseq=#{pseq}")
	public int getRecommend(@Param("pseq") int pseq) throws Exception;

	// recommend_p_view List �޾ƿ���
	@Select("select * from recommend_p_view")
	public List<Integer> getRecommendList() throws Exception;

	// ranking top ��ǰ�� �ƴѰ��� recommend ���� n���� ����
	@Update("update product set recommend='n'where pseq=#{pseq}")
	public int getDeleteRecommend(@Param("pseq") int pseq) throws Exception;

	// 1�� ���� ������ ���� ����Ʈ
	@Select("select * from seller1")
	public List<SellerSales> getSeller1Sale() throws Exception;

	// 2�� ���� ������ ���� ����Ʈ
	@Select("select * from seller2")
	public List<SellerSales> getSeller2Sale() throws Exception;

	// 3�� ���� ������ ���� ����Ʈ
	@Select("select * from seller3")
	public List<SellerSales> getSeller3Sale() throws Exception;

	// 4�� ���� ������ ���� ����Ʈ
	@Select("select * from seller4")
	public List<SellerSales> getSeller4Sale() throws Exception;

	// 5�� ���� ������ ���� ����Ʈ
	@Select("select * from seller5")
	public List<SellerSales> getSeller5Sale() throws Exception;

	// 6�� ���� ������ ���� ����Ʈ
	@Select("select * from seller6")
	public List<SellerSales> getSeller6Sale() throws Exception;

}
