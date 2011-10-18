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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Configuration
public class TubsDataSourceConfig {

	private @Value("#{tubsJdbcProperties.className}") String JDBC_CLASS_NAME;
	private @Value("#{tubsJdbcProperties.tubsURL}") String JDBC_URL;
	
	@Primary
	@Bean(name={"tubsDataSource"})
	public DataSource tubsDataSource() {
		final DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(JDBC_CLASS_NAME);
		dmds.setUrl(JDBC_URL);
		return dmds;
	}
}
