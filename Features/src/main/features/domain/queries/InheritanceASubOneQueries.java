package features.domain.queries;

import java.util.List;

import org.exigencecorp.domainobjects.AbstractQueries;
import org.exigencecorp.domainobjects.queries.Select;

import features.domain.InheritanceASubOne;

public class InheritanceASubOneQueries extends AbstractQueries<InheritanceASubOne> {

    public InheritanceASubOneQueries() {
        super(InheritanceASubOne.class);
    }

    public List<InheritanceASubOne> findAll() {
        InheritanceASubOneAlias sa = new InheritanceASubOneAlias("sa");
        return Select.from(sa).list();
    }

    public InheritanceASubOne findByName(String name) {
        InheritanceASubOneAlias sa = new InheritanceASubOneAlias("sa");
        Select<InheritanceASubOne> q = Select.from(sa);
        q.where(sa.name.equals(name));
        return q.unique();
    }

}