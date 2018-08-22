package ua.rozhkov.springdepdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;
import ua.rozhkov.springdepdb.service.CollegeService;
import ua.rozhkov.springdepdb.service.SpecialityService;

@SpringBootApplication
public class SpringdepdbApplication implements CommandLineRunner {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private CollegeService collegeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringdepdbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        specialityService.add(new Speciality("111", "111"));
        specialityService.add(new Speciality("222", "222"));
    }

    /* @Bean
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        return embeddedDatabaseBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);

        final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan(getClass().getPackage().getName());
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());

        return localContainerEntityManagerFactoryBean;
    }*/
//--------------another config datasource H2--------------------
    /*
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        bean.setShowSql(true);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setPackagesToScan("jcg.zheng.demo.jpademo");
        return bean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }*/
}
