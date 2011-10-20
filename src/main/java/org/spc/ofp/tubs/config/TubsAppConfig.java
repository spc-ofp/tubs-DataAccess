/*
 * Copyright (C) 2011 Secretariat of the Pacific Community
 *
 * This file is part of TUBS.
 *
 * TUBS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TUBS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with TUBS.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spc.ofp.tubs.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.spc.ofp.tubs.domain.common.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Configuration
@Import(TubsDataSourceConfig.class)
public class TubsAppConfig {

	public static final String PU_NAME = "TubsDataPU";
	
	@Autowired
	private TubsDataSourceConfig dataSourceConfig;
	
	@Primary
	@Bean(name={"CommonRepository"})
	public CommonRepository commonRepository() {
		return new CommonRepository();
	}
	
	@Bean(name={"transactionManager"})
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSourceConfig.tubsDataSource());
	}
	
	@Bean(name={"jpaAdapter"})
	public HibernateJpaVendorAdapter jpaAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean(name={"entityManagerFactory"})
	public EntityManagerFactory entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean emf =
		    new LocalContainerEntityManagerFactoryBean(); 
		emf.setDataSource(dataSourceConfig.tubsDataSource());
		// FIXME Change this to read PU name from Spring configuration XML
		emf.setPersistenceUnitName(PU_NAME);
		emf.setJpaVendorAdapter(jpaAdapter());
		final Properties jpaProperties = new Properties();
		// FIXME Change this to read Hibernate dialect from Spring configuration XML
		//jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
		// This sets us up for being able to use the GIS functionality in SQL Server via HibernateSpatial
		jpaProperties.setProperty("hibernate.dialect", "org.hibernatespatial.sqlserver.SQLServerSpatialDialect");
		//jpaProperties.setProperty("hibernate.show_sql", "true");
		emf.setJpaProperties(jpaProperties);
		emf.afterPropertiesSet();
		return emf.getNativeEntityManagerFactory();
	}
}
