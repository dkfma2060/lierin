package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	//�ڵ鷯���� - ��Ʈ�ѷ� ã�� ���� , �ڵ�� ������ ������ �� �ֵ��� �Ѵ�.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/WEB-INF/view/"); // ~form.jsp���� �ڿ� .jsp�� �ٿ������� �ʾƵ� �ȴ�. ��? .jsp() ���п�, �տ� ���丮�� �Ⱥٿ��൵ �ȴ�. prefix() ���п�
	}
}
