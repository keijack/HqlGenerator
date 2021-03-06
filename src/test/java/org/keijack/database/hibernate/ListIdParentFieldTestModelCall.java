package org.keijack.database.hibernate;

import org.keijack.database.hibernate.stereotype.QueryParamsFor;

@QueryParamsFor(value = HibernateEntity.class, fields = { "id", "parent" }, alias = "t", distinct = true)
public class ListIdParentFieldTestModelCall extends QueryHibernateEntityParams {

    @QueryParamsFor(value = HibernateEntity.class, fields = "id", alias = "t", distinct = true)
    public static class ListIdFieldTestModelCall extends ListIdParentFieldTestModelCall {

    }
}
