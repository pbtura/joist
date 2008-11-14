package features.domain;

import features.domain.ParentCBar;
import features.domain.ParentCBarCodegen;
import features.domain.ParentCFoo;
import java.util.ArrayList;
import java.util.List;
import org.exigencecorp.domainobjects.queries.Alias;
import org.exigencecorp.domainobjects.queries.columns.AliasColumn;
import org.exigencecorp.domainobjects.queries.columns.ForeignKeyAliasColumn;
import org.exigencecorp.domainobjects.queries.columns.IdAliasColumn;
import org.exigencecorp.domainobjects.queries.columns.IntAliasColumn;
import org.exigencecorp.domainobjects.queries.columns.StringAliasColumn;

public class ParentCBarAlias extends Alias<ParentCBar> {

    private final List<AliasColumn<ParentCBar, ?, ?>> columns = new ArrayList<AliasColumn<ParentCBar, ?, ?>>();
    public final IdAliasColumn<ParentCBar> id = new IdAliasColumn<ParentCBar>(this, "id", ParentCBarCodegen.Shims.id);
    public final StringAliasColumn<ParentCBar> name = new StringAliasColumn<ParentCBar>(this, "name", ParentCBarCodegen.Shims.name);
    public final IntAliasColumn<ParentCBar> version = new IntAliasColumn<ParentCBar>(this, "version", ParentCBarCodegen.Shims.version);
    public final ForeignKeyAliasColumn<ParentCBar, ParentCFoo> firstParent = new ForeignKeyAliasColumn<ParentCBar, ParentCFoo>(this, "first_parent_id", ParentCBarCodegen.Shims.firstParentId);
    public final ForeignKeyAliasColumn<ParentCBar, ParentCFoo> secondParent = new ForeignKeyAliasColumn<ParentCBar, ParentCFoo>(this, "second_parent_id", ParentCBarCodegen.Shims.secondParentId);

    public ParentCBarAlias(String alias) {
        super(ParentCBar.class, "parent_c_bar", alias);
        this.columns.add(this.id);
        this.columns.add(this.name);
        this.columns.add(this.version);
        this.columns.add(this.firstParent);
        this.columns.add(this.secondParent);
    }

    public List<AliasColumn<ParentCBar, ?, ?>> getColumns() {
        return this.columns;
    }

    public IdAliasColumn<ParentCBar> getIdColumn() {
        return this.id;
    }

    public IntAliasColumn<ParentCBar> getVersionColumn() {
        return this.version;
    }

    public IdAliasColumn<ParentCBar> getSubClassIdColumn() {
        return null;
    }

}