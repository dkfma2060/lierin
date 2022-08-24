package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ProductDao;
import dao.WorkerDao;
import dto.Product;

@Controller
@RequestMapping("worker/kind={kind}")
public class PKindController {
	private ProductDao productDao;
	private WorkerDao workerDao;

	public PKindController setProductDao(ProductDao productDao, WorkerDao workerDao) {
		this.productDao = productDao;
		this.workerDao = workerDao;
		return this;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(@PathVariable("kind") int kind, Model model) {
		try {
			List<Product> products = productDao.selectByCategory(kind);
			List<String> imagebyProduct = new ArrayList<String>();
			for (Product product : products) {
				List<String> images = productDao.selectAllImage(product.getPseq());
				imagebyProduct.add(images.get(0));
			}

			//best_p_view list y->n으로 변경
			List<Integer> bestlist = workerDao.bestList();
			for (int i = 0; i < bestlist.size(); i++) {
				workerDao.deleteBest(bestlist.get(i));
			}
			//best ranking list n->y으로 변경
			List<Integer> ranking = workerDao.rank();
			for (int i = 0; i < ranking.size(); i++) {
				workerDao.best(ranking.get(i));				
			}
			//recommend_p_view list y->n으로 변경
			List<Integer> recommendList = workerDao.recommendList();
			for (int i = 0; i < recommendList.size(); i++) {
				workerDao.deleteRecommend(recommendList.get(i));
			}
			//recommend ranking list n->y으로 변경
			List<Integer> likeRank = workerDao.likeRank();
			for (int i = 0; i < likeRank.size(); i++) {
				workerDao.recommend(likeRank.get(i));				
			}
			
			
/*			
			// best_p_view 에서 ranking에 없는 상품은 best y->n 으로 변경 하는 부분
			List<Integer> ranking = workerDao.rank();
			List<Integer> bestlist = workerDao.bestList();
			// System.out.println(bestlist);
			for (int i = 0; i < ranking.size(); i++) {
				for (int j = 0; j < bestlist.size(); j++) {
					if (ranking.get(i) != bestlist.get(j)) {
						workerDao.deleteBest(bestlist.get(j));
					}
				}
			}
			// ranking top => best_product update(y로 변경하는 부분)
			for (int i = 0; i < ranking.size(); i++) {
				workerDao.best(ranking.get(i));
			}

			// recommend_p_view 에서 ranking에 없는 상품은 best y->n 으로 변경 하는 부분
			List<Integer> likeRank = workerDao.likeRank();
			List<Integer> recommendList = workerDao.recommendList();
			for (int i = 0; i < likeRank.size(); i++) {
				for (int j = 0; j < recommendList.size(); j++) {
					if (ranking.get(i) != recommendList.get(j)) {
						workerDao.deleteRecommend(recommendList.get(j));
					}
				}
			}

			// ranking top => recommend_product update(y로 변경하는 부분)
			for (int i = 0; i < likeRank.size(); i++) {
				workerDao.recommend(likeRank.get(i));
			}
*/			
			model.addAttribute("products", products);
			model.addAttribute("imagebyProduct", imagebyProduct);
			return "worker/ProductKind";

		} catch (Exception e) {
			e.printStackTrace();
			return "worker/ProductManagement";
		}
	}

}
