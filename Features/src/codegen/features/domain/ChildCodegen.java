package features.domain;

import features.domain.ChildAlias;
import features.domain.queries.ChildQueries;
import org.exigencecorp.domainobjects.AbstractDomainObject;
import org.exigencecorp.domainobjects.Shim;
import org.exigencecorp.domainobjects.orm.AliasRegistry;
import org.exigencecorp.domainobjects.orm.ForeignKeyHolder;
import org.exigencecorp.domainobjects.uow.UoW;
import org.exigencecorp.domainobjects.validation.rules.MaxLength;
import org.exigencecorp.domainobjects.validation.rules.NotNull;

abstract class ChildCodegen extends AbstractDomainObject {

    static {
        AliasRegistry.register(Child.class, new ChildAlias("a"));
    }

    public static final ChildQueries queries = new ChildQueries();
    private Integer id = null;
    private String name = null;
    private Integer version = null;
    private ForeignKeyHolder<Parent> parent = new ForeignKeyHolder<Parent>(Parent.class);
    protected org.exigencecorp.domainobjects.Changed changed;

    protected ChildCodegen() {
        this.addExtraRules();
    }

    private void addExtraRules() {
        this.addRule(new NotNull<Child>("name", Shims.name));
        this.addRule(new MaxLength<Child>("name", 100, Shims.name));
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.getChanged().record("id", this.id, id);
        this.id = id;
        if (UoW.isOpen()) {
            UoW.getIdentityMap().store(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.getChanged().record("name", this.name, name);
        this.name = name;
    }

    public Integer getVersion() {
        return this.version;
    }

    public Parent getParent() {
        return this.parent.get();
    }

    public void setParent(Parent parent) {
        if (this.parent.get() != null) {
           this.parent.get().removeChildWithoutPercolation((Child) this);
        }
        this.setParentWithoutPercolation(parent);
        if (this.parent.get() != null) {
           this.parent.get().addChildWithoutPercolation((Child) this);
        }
    }

    public void setParentWithoutPercolation(Parent parent) {
        this.getChanged().record("parent", this.parent, parent);
        this.parent.set(parent);
    }

    public ChildChanged getChanged() {
        if (this.changed == null) {
            this.changed = new ChildChanged((Child) this);
        }
        return (ChildChanged) this.changed;
    }

    public static class Shims {
        public static final Shim<Child, java.lang.Integer> id = new Shim<Child, java.lang.Integer>() {
            public void set(Child instance, java.lang.Integer id) {
                ((ChildCodegen) instance).id = id;
            }
            public Integer get(Child instance) {
                return ((ChildCodegen) instance).id;
            }
        };
        public static final Shim<Child, java.lang.String> name = new Shim<Child, java.lang.String>() {
            public void set(Child instance, java.lang.String name) {
                ((ChildCodegen) instance).name = name;
            }
            public String get(Child instance) {
                return ((ChildCodegen) instance).name;
            }
        };
        public static final Shim<Child, java.lang.Integer> version = new Shim<Child, java.lang.Integer>() {
            public void set(Child instance, java.lang.Integer version) {
                ((ChildCodegen) instance).version = version;
            }
            public Integer get(Child instance) {
                return ((ChildCodegen) instance).version;
            }
        };
        public static final Shim<Child, Integer> parentId = new Shim<Child, Integer>() {
            public void set(Child instance, Integer parentId) {
                ((ChildCodegen) instance).parent.setId(parentId);
            }
            public Integer get(Child instance) {
                return ((ChildCodegen) instance).parent.getId();
            }
        };
    }

    public static class ChildChanged extends org.exigencecorp.domainobjects.AbstractChanged {
        public ChildChanged(Child instance) {
            super(instance);
        }
    }

}
