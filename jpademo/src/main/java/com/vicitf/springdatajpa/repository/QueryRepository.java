package com.vicitf.springdatajpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vicitf.springdatajpa.bean.ChangedTableBean;

/**
 * 查询用类, 不要有任何修改或修改相关动作
 * 
 * @author silcata
 *
 */
@Repository
public class QueryRepository {
	@Autowired
	private EntityManager entityManger;
	
	@SuppressWarnings("unchecked")
	public List<ChangedTableBean> getChangedTables(int oldChangesId, int newChangesId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT st.id \"tableId\", st.schema_name \"schemaName\",");
		sb.append(" st.table_name \"tableName\", max(tc.total_row) - min(tc.total_row) \"changedRows\"");
		sb.append(" FROM test.t_schema_tables st RIGHT JOIN test.t_table_changes tc");
		sb.append(" ON st.id = tc.table_id WHERE tc.change_id IN (:oldChangesId, :newChangesId)");
		sb.append(" GROUP BY st.id HAVING changedRows > 0 ORDER BY 4 DESC, 1 ASC");
		Query query = entityManger.createNativeQuery(sb.toString());
		query.setParameter("oldChangesId", oldChangesId);
		query.setParameter("newChangesId", newChangesId);
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(ChangedTableBean.class));
		return query.getResultList();
	}
	
}
