package fabricaweb2;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestSpringBeans {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		
		Usuario usu = (Usuario) ctx.getBean("usuario");
		System.out.println(usu);

		BasicDataSource bds =  (BasicDataSource) ctx.getBean("dataSource");
		System.out.println(bds.getPassword() + " "+ bds.getUsername() + " "+ bds.getDriverClassName());
		
		ctx.close();
	}

}
