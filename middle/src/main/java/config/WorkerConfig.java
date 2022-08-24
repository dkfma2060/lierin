package config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.IdCheckController;
import controller.IndexController;
import controller.LogOutController;
import controller.PKindController;
import controller.PRegController;
import controller.WAddController;
import controller.WBoardController;
import controller.WBoardUpdateController;
import controller.WDeleteController;
import controller.WLeaveController;
import controller.WListController;
import controller.WLoginController;
import controller.WManagementController;
import controller.WNoticeController;
import controller.WOrderController;
import controller.WOrderDetailController;
import controller.WPromoteController;
import controller.WQnaController;
import controller.WSalesController;
import controller.WUpdateController;
import dao.CustomerDaoImpl;
import dao.OrderDaoImpl;
import dao.ProductDaoImpl;
import dao.SellerDaoImpl;
import dao.WorkerDaoImpl;

@Configuration // Handler Mapping�� ���ؼ� bean�� ã������ Annotation�� �ʿ�
public class WorkerConfig implements WebMvcConfigurer {
	private SqlSessionFactory sqlSessionFactory;

	public WorkerConfig() {
		try {
			String resource = "dao/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			orderDaoImpl = orderDaoImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public WorkerDaoImpl workerDao() {
		WorkerDaoImpl worker = new WorkerDaoImpl();
		worker.setDataSource(sqlSessionFactory);
		return worker;
	}

	@Autowired
	private WorkerDaoImpl workerDao;

	@Bean
	public WLoginController wLoginController() {
		WLoginController wLoginController = new WLoginController();
		wLoginController.setworkerDao(workerDao);
		return wLoginController;
	}

	@Bean
	public WListController wListController() {
		WListController wListController = new WListController();
		wListController.setworkerDao(workerDao);
		return wListController;
	}

	@Bean
	public WAddController wAddController() {
		WAddController wAddController = new WAddController();
		wAddController.setworkerDao(workerDao);
		return wAddController;
	}

	@Bean
	public WUpdateController wUpdateController() {
		WUpdateController wUpdateController = new WUpdateController();
		wUpdateController.setworkerDao(workerDao);
		return wUpdateController;
	}

	@Bean
	public IdCheckController idCheckController() {
		IdCheckController idCheckController = new IdCheckController();
		idCheckController.setworkerDao(workerDao);
		return idCheckController;
	}

	@Bean
	public LogOutController logOutController() {
		return new LogOutController();

	}

//index page---------------------------------------------------------------------------	

	@Bean
	public IndexController indexController() {
		IndexController indexController = new IndexController();
		return indexController;
	}

//ȸ����������---------------------------------------------------------------------------------	
	
	@Autowired
	private CustomerDaoImpl customerDao;

	@Bean
	public CustomerDaoImpl customerDao() {
		CustomerDaoImpl customer = new CustomerDaoImpl();
		customer.setDataSource(sqlSessionFactory);
		return customer;
	}
	
	@Autowired
	private SellerDaoImpl sellerDao;

	@Bean
	public SellerDaoImpl sellerDao() {
		SellerDaoImpl seller = new SellerDaoImpl();
		seller.setDataSource(sqlSessionFactory);
		return seller;
	}

	// ȸ�� ����
	@Bean
	public WManagementController wManagementController() {
		WManagementController wManagementController = new WManagementController();
		//sellerDao = sellerDao();
		//customerDao = customerDao();		
		wManagementController.setDao(customerDao, sellerDao);
		return wManagementController;
	}

	// ȸ�� ���� Ż��
	@Bean
	public WDeleteController wDeleteController() {
		WDeleteController wDeleteController = new WDeleteController();
		//sellerDao = sellerDao();
		//customerDao = customerDao();	
		wDeleteController.setDao(customerDao, sellerDao);
		return wDeleteController;
	}

	// Ż�� ��û�� ȸ��
	@Bean
	public WLeaveController wLeaveController() {
		WLeaveController wLeaveController = new WLeaveController();
		//sellerDao = sellerDao();
		//customerDao = customerDao();	
		wLeaveController.setDao(customerDao, sellerDao);
		return wLeaveController;
	}

	// customer grade promote
	@Bean
	public WPromoteController wPromoteController() {
		WPromoteController wPromoteController = new WPromoteController();
		//sellerDao = sellerDao();
		//customerDao = customerDao();	
		wPromoteController.setDao(customerDao);
		return wPromoteController;
	}
	
	
//��ǰ����-----------------------------------------------------------------------------	

	@Autowired
	private ProductDaoImpl productDao;

	@Bean
	public ProductDaoImpl productDao() {
		ProductDaoImpl productDao = new ProductDaoImpl();
		//productDao = productDao();
		productDao.setDataSource(sqlSessionFactory);
		return productDao;
	}

	@Bean // ī�װ��� ��ǰ ����Ʈ
	public PKindController pKindController() {
		PKindController pKindController = new PKindController();
		pKindController.setProductDao(productDao,workerDao);
		return pKindController;
	}

	@Bean // ��ǰ ���
	public PRegController pRegController() {
		PRegController pRegController = new PRegController();
		pRegController.setProductDao(productDao, workerDao);
		return pRegController;
	}

//�ֹ���������---------------------------------------------------------------------------

	private OrderDaoImpl orderDaoImpl;

	public OrderDaoImpl orderDaoImpl() {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		orderDaoImpl.setDataSource(sqlSessionFactory);
		return orderDaoImpl;
	}

	@Bean //������ �ֹ� ����Ʈ
	public WOrderController wOrderController() {
		WOrderController wOrderController = new WOrderController();
		wOrderController.setOrderDaoImpl(orderDaoImpl,sellerDao);
		return wOrderController;

	}
	
	@Bean
	public WOrderDetailController wOrderDetailController() {
		WOrderDetailController wOrderDetailController = new WOrderDetailController();
		wOrderDetailController.setOrderDaoImpl(orderDaoImpl);
		return wOrderDetailController;
	}

//�Խ��ǰ���---------------------------------------------------------------------------	

	@Bean // �Խù� ��� type =0 �϶� �������� type=1 �̸� QnA
	public WBoardController wBoardController() {
		WBoardController wBoardController = new WBoardController();
		wBoardController.setNoticeDao(workerDao);
		return wBoardController;
	}

	@Bean // �������� List
	public WNoticeController wNoticeController() {
		WNoticeController wNoticeController = new WNoticeController();
		wNoticeController.setNoticeDao(workerDao);
		return wNoticeController;
	}

	@Bean // QnA List
	public WQnaController wQnaController() {
		WQnaController wQnaController = new WQnaController();
		wQnaController.setNoticeDao(workerDao);
		return wQnaController;
	}

	@Bean
	public WBoardUpdateController wBoardUpdateController() {
		WBoardUpdateController wBoardUpdateController = new WBoardUpdateController();
		wBoardUpdateController.setNoticeDao(workerDao);
		return wBoardUpdateController;
	}

//�������---------------------------------------------------------------------------	

	@Bean
	public WSalesController wSalesController() {
		WSalesController wSalesController = new WSalesController();
		wSalesController.setDao(workerDao);
		return wSalesController;
	}

}
