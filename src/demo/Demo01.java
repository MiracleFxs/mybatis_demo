package demo;

import java.io.IOException;

import java.util.List;

import org.apache.ibatis.session.SqlSession;




import dao.StudentDao;
import util.SqlSessionFactoryUtil;
import entity.Student;

public class Demo01 {

	public static void main(String[] args) {
		//			//从配置文件中构建SqlSessionFactory工厂对象
		//			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
		//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//		
		//			//获取sqlsession对象
		//			SqlSession session=sqlSessionFactory.openSession();
					SqlSession session=SqlSessionFactoryUtil.getSession();
					
					try {
						//通过SqlSession对象进行数据库各种操作：selectOne(),selectList(),update()...
//						Student stu=session.selectOne("mapper.StudentMapper.selectStudentById",0);
						
						//初始化Dao接口对象
						StudentDao stuDao=session.getMapper(StudentDao.class);
						Student stu=stuDao.selectStudentById(0);
						if(stu==null){
							System.out.println("没有找到！");
						}else{
							System.out.println(stu);
						}
						
						System.out.println("-------------");
						//查询多个
//						List<Student> stuList=session.selectList("mapper.StudentMapper.selectStudentList");
						List<Student> stuList=stuDao.selectStudentList();
						for(Student s : stuList){
							System.out.println(s);
						}
						
						
					} finally {
						session.close();
					}

	}

}
