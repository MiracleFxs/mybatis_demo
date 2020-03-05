package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 会话工厂工具类，单例
 * @author fxs
 *
 */
public class SqlSessionFactoryUtil {

	private  static SqlSessionFactory sqlSessionFactory=null;
	
	/**
	 * 获取SqlSession对象
	 * @return
	 */
	public static SqlSession getSession(){
		try {
			if (sqlSessionFactory == null) {
				//初始化SqlSessionFactory
				//从配置文件中构建SqlSessionFactory工厂对象
				InputStream inputStream = Resources
						.getResourceAsStream("mybatis.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(inputStream);
			}
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
